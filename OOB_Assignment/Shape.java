package OOB_Assignment;

public abstract class Shape {
    // I made position and sides private to keep my shape's data safe from outside changes.
    private Coordinates position;
    private int sides;

    public Shape(int noOfSides, Coordinates coord) {
        // Using Math.abs() so I don't accidentally create a shape with negative sides.
        this.sides = Math.abs(noOfSides);
        this.position = coord;
    }

    public Coordinates getCoordinates() {
        return position;
    }

    public int getSides() {
        return sides;
    }

    public void setCoordinates(Coordinates newcoord) {
        this.position = newcoord;
    }

    public void translate(int dx, int dy) {
        // Instead of writing new code, I'm just calling the translate method I already wrote in my Coordinates class.
        // This makes my code much cleaner and reuses existing logic.
        position.translate(dx, dy);
    }

    public void scale(int factor, boolean sign) {
        // Same here, just reusing the scale method from my Coordinates class.
        position.scale(factor, sign);
    }

    // I made these methods abstract because a general "Shape" doesn't have a specific formula for area or perimeter.
    // My specific shapes (like Rectangle or Circle) will have to provide their own math for these.
    public abstract double getArea();
    public abstract double getPerimeter();

    public String display() {
        return "Position: [" + position.display() + "], Sides: " + sides;
    }
}