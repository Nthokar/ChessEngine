package Chess.Desk;

import Chess.Figures.Figure;
import Chess.Figures.Pawn;

import java.awt.*;

import java.util.HashMap;

public class Desk {
    //  (x,y;cell-color;figure)
    //  EXAMPLE 1,1;default;;
    //  cell-color default means colors determine by cell even
    public Cell[] cells;
    public Desk(Cell[] cells){
        this.cells = cells;
    }

    public void print(){
        String[][] cells = new String[8][8];
        for (var cell:this.cells){
            cells[cell.x][cell.y] = cell.getFigure() == null ? " "://String.format("%s,%s",cell.x,cell.y) :
                    cell.getFigure().color == Color.WHITE ? cell.getFigure().toString(): cell.getFigure().toString().toUpperCase();
        }
        for (int i = 0; i < 8; i++){
            System.out.println("+-----+-----+-----+-----+-----+-----+-----+-----+");
            System.out.print("|");
            for (int j = 0; j < 8; j++){
                System.out.printf("  %s  |",cells[j][i]);
            }
            System.out.printf(" %s%n", i+1);
        }
        System.out.println("+-----+-----+-----+-----+-----+-----+-----+-----+");
        System.out.println("   h     g     f     e     d     c     b     a");

    }

    static public Cell[] setDefault(){
        Cell[] cells = new Cell[64];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                var currentCell = new Cell(j, i);
                cells[i*8 + j]= currentCell;
            }
        }
        int i = 1;
        for (int j = 0; j < 8; j++){
            cells[i*8 + j].setFigure(new Pawn(Color.WHITE));
        }
        i = 6;
        for (int j = 0; j < 8; j++){
            cells[i*8 + j].setFigure(new Pawn(Color.BLACK));
        }
        return cells;
    }
}
