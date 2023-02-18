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

    }

    @Override
    public Cell[] pathTo(Cell cellFrom, Cell cellTo, Cell[][] board) {
        return new Cell[0];
    }
}
