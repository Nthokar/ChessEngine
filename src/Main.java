import Chess.Figures.MoveChecker;

import Chess.Desk.*;
import Chess.Figures.Pawn;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Desk desk = new Desk(Desk.setDefault());
        var moveChecker = new MoveChecker(desk.cells);
        desk.print();
        Cell cell = new Cell(0, 0);
        for (var i:desk.cells){
            if (i.getFigure() != null)
                cell = i;
        }
        for (var i:desk.cells){
            if (i.getFigure() != null){
                for (var move: ((Pawn) i.getFigure()).legalCells){
                    if (Arrays.stream(desk.cells).anyMatch( c -> c.equals(new Cell(move.x + i.x, move.y + i.y)))) {
                        var newCell = desk.cells[move.x + i.x + (move.y + i.y)*8];
                        i.moveFigure(newCell);
                    }
                    desk.print();
                }
            }
        }
        desk.print();
    }
}