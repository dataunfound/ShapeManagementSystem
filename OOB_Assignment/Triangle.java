package OOB_Assignment;

public class Triangle extends Shape {
    // A triangle needs 3 points. The superclass holds the first one (position),
    // so I only need to declare the other two vertices here.
    private Coordinates v2;
    private Coordinates v3;

    public Triangle(Coordinates v1, Coordinates v2, Coordinates v3) {
        // Passing the first vertex (v1) and the number of sides (3) to the Shape class.
        super(3, v1);
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public double getPerimeter() {
        // I calculate the distance between all three vertices to get the side lengths (a, b, c).
        double a = getCoordinates().distance(v2);
        double b = v2.distance(v3);
        double c = v3.distance(getCoordinates());
        return a + b + c;
    }

    @Override
    public double getArea() {
        double a = getCoordinates().distance(v2);
        double b = v2.distance(v3);
        double c = v3.distance(getCoordinates());

        // Calculating the semi-perimeter (s) as required by Heron's formula.
        double s = (a + b + c) / 2.0;

        // This is the value that goes inside the square root.
        double rootValue = s * (s - a) * (s - b) * (s - c);

        // If the coordinates entered don't actually form a valid triangle, rootValue could be negative.
        // Math.sqrt on a negative number returns NaN (Not a Number) and breaks things.
        // I added this check to return 0.0 instead of letting the program produce a NaN error.
        if (rootValue <= 0) {
            return 0.0;
        }

        return Math.sqrt(rootValue);
    }

    @Override
    public void translate(int dx, int dy) {
        // Unlike other shapes, I have to override translate here because I need to move all 3 points.
        super.translate(dx, dy); // This moves v1 (stored in the superclass)
        v2.translate(dx, dy);    // This moves v2
        v3.translate(dx, dy);    // This moves v3
    }

    @Override
    public void scale(int factor, boolean sign) {
        // Same logic as translate: I have to scale every single vertex of the triangle.
        super.scale(factor, sign);
        v2.scale(factor, sign);
        v3.scale(factor, sign);
    }

    @Override
    public String display() {
        return "Shape: Triangle, Vertices: [" +
                getCoordinates().display() + "] - [" +
                v2.display() + "] - [" +
                v3.display() + "]" +
                ", Area: " + getArea() + ", Perimeter: " + getPerimeter();
    }
}