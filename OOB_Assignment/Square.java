package OOB_Assignment;

public class Square extends Shape {
    private double side;

    public Square(Coordinates coord, double side) {
        // I passed 4 to the superclass constructor because a square always has 4 sides.
        super(4, coord);

        // I'm enforcing a positive value here using Math.abs().
        // A negative side length would completely break my area and perimeter logic.
        this.side = Math.abs(side);
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public void scale(int factor, boolean sign) {
        // I first scale the main coordinate of the shape using the parent method.
        super.scale(factor, sign);

        if (sign == true) {
            this.side *= factor;
        } else {
            // Preventing a division by zero error here, just like I did in my other classes!
            if (factor != 0) {
                this.side /= factor;
            }
        }
    }

    @Override
    public String display() {
        return "Shape: Square, " + super.display() +
                ", Side: " + side +
                ", Area: " + getArea() + ", Perimeter: " + getPerimeter();
    }
}