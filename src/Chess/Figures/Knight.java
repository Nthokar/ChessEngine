package Chess.Figures;

import Chess.Desk.Cell;
import Chess.Desk.Vector;
import jdk.jshell.spi.ExecutionControl;

import java.awt.*;
import java.util.Arrays;

public class Knight extends Figure{
    public Knight(Color color) {
        super("knight", color);

    }
    public final Vector[] legalCells = new Vector[] {
        new Vector(+2, +1), new Vector(+2, -1),
        new Vector(-2, +1), new Vector(-2, -1),
        new Vector(+1, +2), new Vector(+1, -2),
        new Vector(-1, +2), new Vector(-1, -2) };;

    @Override
    public Cell[] availableCells() throws ExecutionControl.NotImplementedException {
        return new Cell[0];
    }

    @Override
    public void move(Cell cellFrom, Cell cellTo) {
        Vector vector = cellFrom.getVector(cellTo);

        if (Arrays.stream(legalCells).anyMatch(c -> c.equals(vector)) &&
                (cellTo.getFigure() == null || cellTo.getFigure().color != color)){
            cellFrom.moveFigure(cellTo);
        }
    }

    @Override
    public void move(Cell[] cells) {
        if (cells.length == 0)
            return;
        cells[0].moveFigure(cells[1]);
    }

    @Override
    public Cell[] pathTo(Cell cellFrom, Cell cellTo, Cell[][] board) {
        cellFrom = board[cellFrom.x - 1][cellFrom.y - 1];
        cellTo = board[cellTo.x - 1][cellTo.y - 1];
        Vector vector = cellFrom.getVector(cellTo);
        if (Arrays.stream(legalCells).anyMatch(c -> c.equals(vector)) &&
                (cellTo.getFigure() == null || cellTo.getFigure().color != color)) {
            return new Cell[]{cellFrom, cellTo};
        }
        return new Cell[0];
    }
}
