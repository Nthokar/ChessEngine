package Chess.Figures;

import Chess.Desk.Cell;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveChecker {
    public MoveChecker(Cell[][] board){
        this.board = board;
    }
    public Cell[][] board;
    public Cell[] upperLeftDiagonal(Cell cell){
        return CellsInDirection(cell, -1, +1);
    }
    public Cell[] upperRightDiagonal(Cell cell){
        return CellsInDirection(cell, +1, +1);
    }
    public Cell[] downLeftDiagonal(Cell cell){
        return CellsInDirection(cell, -1, -1);
    }
    public Cell[] downRightDiagonal(Cell cell){
        return CellsInDirection(cell, +1,-1);
    }
    public Cell[] rightHorizontal(Cell cell){
        return CellsInDirection(cell, +1, 0);
    }
    public Cell[] leftHorizontal(Cell cell){
        return CellsInDirection(cell, -1, 0);
    }
    public Cell[] upperVertical (Cell cell){
        return CellsInDirection(cell, 0, +1);
    }
    public Cell[] downVertical(Cell cell){
        return CellsInDirection(cell, 0, -1);
    }

    public Cell[] CellsInDirection(Cell cell, int dx, int dy){
        Cell newCell = new Cell(cell.x + dx, cell.y + dy);
        if (isMovePossible(cell, newCell)){
            var raisedArray = new ArrayList<Cell>();
            raisedArray.add(cell);
            raisedArray.addAll(Arrays.asList(upperLeftDiagonal(newCell)));
            return raisedArray.toArray(Cell[]::new);
        }
        return new Cell[]{cell};
    }

    public boolean isMovePossible(Cell cellFrom, Cell cellTo){
        if (Arrays.stream(board).anyMatch(c -> c.equals(cellTo)) && cellTo.getFigure() == null){
            return true;
        }
        return false;
    }//
}
