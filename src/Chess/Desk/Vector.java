package Chess.Desk;

public class Vector{
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    public final double x;
    public final double y;

    public boolean equals(Vector vector) {
        return this.x == vector.x && this.y == vector.y;
    }
    public boolean equals(Cell cell) {
        return this.x == (double) cell.x && this.y == (double) cell.y;
    }

}