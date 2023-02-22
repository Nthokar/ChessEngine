package Chess.Desk;

import Chess.Desk.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class MoveChecker {
    public MoveChecker(Cell[][] board){
        this.board = board;
    }
    public Cell[][] board;
    public Cell[] CellsInDirection(Cell cell, int dx, int dy){
        Cell newCell = new Cell(cell.x + dx, cell.y + dy);
        if (isMovePossible(cell, newCell)){
            var raisedArray = new ArrayList<Cell>();
            raisedArray.add(cell);
            raisedArray.addAll(Arrays.asList(newCell));
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

    @FunctionalInterface
    public interface CellsInDirection{
        Cell[] getCells(Cell cell);
    }
    public static final HashMap<String, Vector> Directions = new HashMap<String, Vector>(){{
        put("upperLeftDiagonal", new Vector<>(-1,+1));
        put("upperRightDiagonal", new Vector<>(+1,+1));
        put("downLeftDiagonal", new Vector<>(-1,-1));
        put("downRightDiagonal", new Vector<>(+1,-1));
        put("rightHorizontal", new Vector<>(+1,0));
        put("leftHorizontal", new Vector<>(-1,0));
        put("upperVertical", new Vector<>(0,+1));
        put("downVertical", new Vector<>(0,+1));
    }};
}
