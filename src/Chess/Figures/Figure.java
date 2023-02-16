package Chess.Figures;

import Chess.Desk.Cell;

public abstract class Figure {
    public final String name;
    public final int materialCost;
    public Figure(String name, int materialCost){
        this.name = name;
        this.materialCost = materialCost;
    }

    public abstract void moveTo();
    public abstract Cell[] availableCells();
}
