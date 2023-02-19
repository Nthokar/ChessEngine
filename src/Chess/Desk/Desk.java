package Chess.Desk;

import Chess.Figures.*;

import java.awt.*;

import java.util.HashMap;

public class Desk {
    //  (x,y;cell-color;figure)
    //  EXAMPLE 1,1;default;;
    //  cell-color default means colors determine by cell even
    public Cell[][] cells;
    public Desk(Cell[][] cells){
        this.cells = cells;
    }

    public void print(){
        for (int i = 7; i >= 0; i--){
            System.out.println("+-----+-----+-----+-----+-----+-----+-----+-----+");
            System.out.print("|");
            for (int j = 0; j < 8; j++){
                System.out.printf("  %s  |",cells[j][i]);
            }
            System.out.printf(" %s%n", i+1);
        }
        System.out.println("+-----+-----+-----+-----+-----+-----+-----+-----+");
        System.out.println("   a     b     c     d     e     f     g     h");

    }

    static public Cell[][] setDefault(){
        Cell[][] cells = new Cell[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                var currentCell = new Cell(j+1, i+1);
                cells[j][i] = currentCell;
            }
        }
        int i = 1;
        for (int j = 0; j < 8; j++){
            cells[j][i].setFigure(new Pawn(Color.WHITE));
        }
        i = 6;
        for (int j = 0; j < 8; j++){
            cells[j][i].setFigure(new Pawn(Color.BLACK));
        }
        cells[0][0].setFigure(new Rook(Color.WHITE));
        cells[1][0].setFigure(new Knight(Color.WHITE));
        cells[2][0].setFigure(new Bishop(Color.WHITE));
        cells[3][0].setFigure(new Queen(Color.WHITE));
        return cells;
    }
}
