package Chess.Desk;

import Chess.Figures.Figure;

public class Cell {
    private Figure figure;
    public final int x;
    public final int y;
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

    public boolean equals(Cell cell) {
        return this.x == cell.x && this.y == cell.y;
    }

    public boolean equals(Vector vector) {
        return this.x == vector.x && this.y == vector.y;
    }

}
