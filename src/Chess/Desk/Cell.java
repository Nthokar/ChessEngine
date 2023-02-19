package Chess.Desk;

import Chess.Figures.Figure;

import java.util.ArrayList;

public class Cell {
    private Figure figure;
    public final int x;
    public final int y;
    public ArrayList<Cell> attackingPieces = new ArrayList<Cell>();
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector getVector(Cell cellTo){
        return new Vector(cellTo.x - this.x, cellTo.y - this.y);
    }
    public Figure getFigure(){
        return figure;
    }
    public void moveFigure(Cell cellTo){
        if (cellTo.equals(this))
            return;
        cellTo.figure = figure;
        this.figure = null;
    }
    public void setFigure(Figure figure){
        this.figure = figure;
    }
    @Override
    public String toString() {
        return figure == null ? " " : figure.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Cell)
            return this.x == ((Cell) o).x && this.y == ((Cell) o).y;
        return false;
    }
    public boolean equals(Vector vector) {
        return this.x == vector.x && this.y == vector.y;
    }
}
