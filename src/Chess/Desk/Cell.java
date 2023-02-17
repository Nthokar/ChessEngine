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

    public Cell getVector(Cell cellTo){
        return new Cell(cellTo.x - this.x, cellTo.y - this.y);
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
        return String.format("%s - %s", x, y);
    }

    public boolean equals(Cell cell) {
        return this.x == cell.x && this.y == cell.y;
    }
}
