import Chess.Figures.MoveChecker;

import Chess.Desk.*;
import Chess.Figures.Pawn;
import Chess.Parser.ConsoleMoveReader;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Desk desk = new Desk(Desk.setDefault());
        desk.print();
        var path = desk.cells[0][0].getFigure().pathTo(desk.cells[0][0], desk.cells[7][0], desk.cells);
//        for (var i:desk.cells){
//            if (i.getFigure() != null){
//                for (var move: ((Pawn) i.getFigure()).legalCells){
//                    if (Arrays.stream(desk.cells).anyMatch( c -> c.equals(new Cell(move.x + i.x, move.y + i.y)))) {
//                        var newCell = desk.cells[move.x + i.x + (move.y + i.y)*8];
//                        i.moveFigure(newCell);
//                    }
//                    desk.print();
//                }
//            }
//        }
        Scanner myObj = new Scanner(System.in);

        for(;;){
            var input = myObj.nextLine();
            var move = ConsoleMoveReader.readMove(input);
            var cell = move.from;
            var cellTo = move.to;
            cell = desk.cells[cell.x][cell.y - 1];
            cellTo = desk.cells[cellTo.x][cellTo.y - 1];
            if (cell.getFigure() == null){
                System.out.println("choose possible move!");
                continue;
            }
            path = cell.getFigure().pathTo(cell, cellTo, desk.cells);
            cell.getFigure().move(path);
            desk.print();
        }
    }
}