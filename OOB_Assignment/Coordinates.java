package OOB_Assignment;

public class Coordinates {
    // I made these private so other classes can't mess with the coordinates directly.
    // The assignment brief mentions the origin is top-left, meaning x and y should be positive.
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        // I used Math.abs() here just in case I accidentally pass a negative value when testing.
        // This guarantees my coordinates stay positive on the canvas.
        this.x = Math.abs(x);
        this.y = Math.abs(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Coordinates p) {
        // I'm applying the distance formula given in the assignment: sqrt((x2-x1)^2 + (y2-y1)^2)
        // Splitting it into xDiff and yDiff makes the Math.sqrt line much easier for me to read.
        double xDiff = p.getX() - this.x;
        double yDiff = p.getY() - this.y;
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;

        // If I translate a shape too far left or up, it might go into negative coordinates.
        // I added these if statements to lock them at 0 so it stays on the valid canvas area.
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.y < 0) {
            this.y = 0;
        }
    }

    public void scale(int factor, boolean sign) {
        if (sign == true) {
            this.x *= factor;
            this.y *= factor;
        } else {
            // I have to make sure the factor isn't 0 before dividing, otherwise my program will crash.
            if (factor != 0) {
                this.x /= factor;
                this.y /= factor;
            }
        }
    }

    public String display() {
        return "X = " + x + ", Y = " + y;
    }
}