package Chess.Desk;

import Chess.Figures.Figure;

import java.util.Optional;

public class Cell {
    public final int x;
    public final int y;
    public Figure figure;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
}
