package OOB_Assignment;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(Coordinates coord, double width, double length) {
        // A rectangle always has 4 sides, so I hardcoded '4' for the superclass constructor.
        super(4, coord);

        // I'm using Math.abs() because a negative width or length doesn't make sense in real geometry.
        this.width = Math.abs(width);
        this.length = Math.abs(length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (2 * width) + (2 * length);
    }

    @Override
    public void scale(int factor, boolean sign) {
        // First, I need to scale the position using the method from the parent Shape class.
        super.scale(factor, sign);

        // Then I scale the actual width and length of my rectangle.
        if (sign == true) {
            this.width *= factor;
            this.length *= factor;
        } else {
            // I added this check to prevent a divide-by-zero crash, which is a common edge case!
            if (factor != 0) {
                this.width /= factor;
                this.length /= factor;
            }
        }
    }

    @Override
    public String display() {
        return "Shape: Rectangle, " + super.display() +
                ", Width: " + width + ", Length: " + length +
                ", Area: " + getArea() + ", Perimeter: " + getPerimeter();
    }
}