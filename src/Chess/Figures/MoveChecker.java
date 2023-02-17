package Chess.Figures;

import Chess.Desk.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MoveChecker {
    public MoveChecker(Cell[] cells){
        this.cells = cells;
    }
    public Cell[] cells;
    public Cell[] UpperLeftDiagonal(Cell cell){
        return CellsInDirection(cell, +1, +1);
    }

    public Cell[] CellsInDirection(Cell cell, int dx, int dy){
        Cell newCell = new Cell(cell.x + dx, cell.y + dy);
        if (isMovePossible(cell, newCell)){
            var raisedArray = new ArrayList<Cell>();
            raisedArray.add(cell);
            raisedArray.addAll(Arrays.asList(UpperLeftDiagonal(newCell)));
            return raisedArray.toArray(Cell[]::new);
        }
        return new Cell[]{cell};
    }

    public boolean isMovePossible(Cell cellFrom, Cell cellTo){
        if (Arrays.stream(cells).anyMatch(c -> c.equals(cellTo)) && cellTo.getFigure() == null){
            return true;
        }
        return false;
    }
}
