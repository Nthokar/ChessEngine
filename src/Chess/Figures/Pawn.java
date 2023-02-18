package Chess.Figures;

import Chess.Desk.Cell;
import Chess.Desk.Vector;
import jdk.jshell.spi.ExecutionControl;

import java.awt.*;
import java.util.ArrayList;
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
        if (cells.length == 0)
            return;
        for (var i = 1; i < cells.length - 1; i++){
            var cell = cells[i];
            if (cell.getFigure() != null)
                return;
        }
        if (cells[cells.length - 1].getFigure() != null && cells[0].x == cells[1].x){
            return;
        }
        cells[0].moveFigure(cells[cells.length - 1]);
        isMoved = true;
    }

    @Override
    public Cell[] pathTo(Cell cellFrom, Cell cellTo, Cell[][] board) {
        cellFrom = board[cellFrom.x - 1][cellFrom.y - 1];
        cellTo = board[cellTo.x - 1][cellTo.y -1];
        var vector = cellFrom.getVector(cellTo);
        if (Arrays.stream(legalCells).anyMatch(c -> c.equals(vector))
                && cellTo.getFigure() == null){
            return new Cell[]{cellFrom, cellTo};
        }
        else if (Arrays.stream(capture).anyMatch(c -> c.equals(vector))
                && cellTo.getFigure().color != color){
            return new Cell[]{cellFrom, cellTo};
        }
        else {
            if (Arrays.stream(possibleCells).anyMatch(c -> c.equals(vector))
                && !isMoved
                && cellTo.getFigure() == null){
                var unitVector = vector.getUnitVector();
                var currentCell = cellFrom;
                ArrayList<Cell> path = new ArrayList<>();
                path.add(currentCell);
                while (currentCell != cellTo){
                    currentCell = board[currentCell.x + (int) unitVector.x - 1][currentCell.y + (int) unitVector.y - 1];
                    path.add(currentCell);
                }
                return path.toArray(Cell[]::new);
            }
        }
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
