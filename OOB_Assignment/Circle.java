package OOB_Assignment;

public class Circle extends Shape {
    private double radius;

    public Circle(Coordinates coord, double radius) {
        // A circle doesn't have straight sides, so I pass 0 to the superclass.
        super(0, coord);

        // Just making sure the radius is always positive.
        this.radius = Math.abs(radius);
    }

    @Override
    public double getArea() {
        // Formula is PI * r^2
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        // Formula is 2 * PI * r
        return 2 * Math.PI * radius;
    }

    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign); // Scales the center position

        if (sign == true) {
            this.radius *= factor;
        } else {
            // Standard check to avoid crashing my program if factor is 0.
            if (factor != 0) {
                this.radius /= factor;
            }
        }
    }

    @Override
    public String display() {
        return "Shape: Circle, " + super.display() +
                ", Radius: " + radius +
                ", Area: " + getArea() + ", Perimeter: " + getPerimeter();
    }
}
