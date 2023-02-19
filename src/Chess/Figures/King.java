package Chess.Figures;

import Chess.Desk.Cell;
import Chess.Desk.Vector;
import jdk.jshell.spi.ExecutionControl;

import java.awt.*;

public class King extends Figure{
    public King(Color color) {
        super("king", color);
    }

    public Cell[] legalCells = new Cell[]{
            new Cell(0, +1), new Cell(0, -1),
            new Cell(+1, +1), new Cell(+1, 0), new Cell(+1, -1),
            new Cell(-1, +1), new Cell(-1, 0), new Cell(-1, -1),
    };

    @Override
    public Cell[] availableCells() throws ExecutionControl.NotImplementedException {
        return new Cell[0];
    }

    @Override
    public void move(Cell cellFrom, Cell cellTo) {
    }

    @Override
    public void move(Cell[] cells) {
    }

    @Override
    public Cell[] pathTo(Cell cellFrom, Cell cellTo, Cell[][] board) {
        return new Cell[0];
    }
}
