package Chess.Figures;

import Chess.Desk.Cell;
import jdk.jshell.spi.ExecutionControl;

import java.awt.*;
import java.util.Arrays;

public class Pawn extends Figure {
    public Pawn(Color color) {
        super("pawn", color);
        if (color == Color.BLACK) {
            legalCells = new Cell[]{ new Cell(0,-1)};
            possibleCells = new Cell[]{ new Cell(+1, -1), new Cell(-1, -1), new Cell(0, -2)};
        }
        else {
            legalCells = new Cell[]{ new Cell(0,+1)};
            possibleCells = new Cell[]{ new Cell(-1, +1), new Cell(+1, +1), new Cell(0, +2)};
        }
    }
    private boolean isMoved = false;
    private boolean isEnemyOnLeft = false;
    private boolean isEnemyOnRight = false;

    public final Cell[] legalCells;
    public final Cell[] possibleCells;
    @Override
    public Cell[] availableCells() throws ExecutionControl.NotImplementedException {
        return new Cell[0];
    }

    public boolean isMoved() {
        return isMoved;
    }

    @Override
    public void move(Cell cellFrom, Cell cellTo) {
        Cell vector = cellFrom.getVector(cellTo);
        if (Arrays.stream(legalCells).anyMatch(c -> c.equals(vector))){
            cellFrom.moveFigure(cellTo);
            isMoved = true;
        }
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
