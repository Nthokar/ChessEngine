package Chess.Figures;

import Chess.Desk.Cell;
import jdk.jshell.spi.ExecutionControl;

import java.awt.*;
import java.util.HashSet;

public abstract class Figure {
    public Figure(String name, Color color){
        this.name = name;
        this.color = color;
    }
    public final String name;
    public final Color color;

    public abstract Cell[] availableCells() throws ExecutionControl.NotImplementedException;
    public abstract void move(Cell cellFrom, Cell cellTo);

    @Override
    public String toString() {
        return String.valueOf(name.charAt(0));
    }
}
