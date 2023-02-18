package Chess.Figures;

import Chess.Desk.Cell;
import Chess.Desk.Vector;
import jdk.jshell.spi.ExecutionControl;

import java.awt.*;
import java.util.Arrays;

public class Pawn extends Figure {
    public Pawn(Color color) {
        super("pawn", color);
        if (color == Color.BLACK) {
            legalCells = new Vector[]{ new Vector(0,-1)};
            possibleCells = new Vector[]{ new Vector(0, -2)};
            capture = new Vector[]{ new Vector(+1, -1), new Vector(-1, -1)};
        }
        else {
            legalCells = new Vector[]{ new Vector(0,+1)};
            possibleCells = new Vector[]{new Vector(0, +2)};
            capture = new Vector[]{ new Vector(-1, +1), new Vector(+1, +1)};
        }
    }
    private boolean isMoved = false;
    private boolean isEnemyOnLeft = false;
    private boolean isEnemyOnRight = false;

    public final Vector[] legalCells;
    public final Vector[] possibleCells;
    public final Vector[] capture;
    @Override
    public Cell[] availableCells() throws ExecutionControl.NotImplementedException {
        return new Cell[0];
    }

    public boolean isMoved() {
        return isMoved;
    }

    @Override
    public void move(Cell cellFrom, Cell cellTo) {
        var vector = cellFrom.getVector(cellTo);
        if (Arrays.stream(legalCells).anyMatch(c -> c.equals(vector)) && cellTo.getFigure() == null){
            cellFrom.moveFigure(cellTo);
            isMoved = true;
        }
        else if (Arrays.stream(capture).anyMatch(c -> c.equals(vector)) && cellTo.getFigure().color != color){
            cellFrom.moveFigure(cellTo);
            isMoved = true;
        }
        else {
                if (Arrays.stream(possibleCells).anyMatch(c -> c.equals(vector)) && !isMoved && cellTo.getFigure() == null){
                cellFrom.moveFigure(cellTo);
                isMoved = true;
            }
        }
    }

    @Override
    public void move(Cell[] cells) {

    }

    @Override
    public Cell[] pathTo(Cell cellFrom, Cell cellTo, Cell[][] board) {
        return new Cell[0];
    }

    public boolean isEnemyOnLeft() {
        return isEnemyOnLeft;
    }

    public void setEnemyOnLeft(boolean enemyOnLeft) {
        isEnemyOnLeft = enemyOnLeft;
    }

    public boolean isEnemyOnRight() {
        return isEnemyOnRight;
    }

    public void setEnemyOnRight(boolean enemyOnRight) {
        isEnemyOnRight = enemyOnRight;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("i am dying");
    }
}
