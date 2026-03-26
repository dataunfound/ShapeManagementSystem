package OOB_Assignment;

import java.util.ArrayList;

public class ShapeList {
    // I'm using an ArrayList because it automatically resizes when I add or remove shapes,
    // which is much easier and safer than dealing with standard fixed-size arrays.
    private ArrayList<Shape> listofShapes;

    public ShapeList() {
        // Initializing my empty list here so it's ready to store shapes.
        this.listofShapes = new ArrayList<>();
    }

    public void addShape(Shape s) {
        listofShapes.add(s);
        System.out.println("Shape added successfully.");
    }

    public Shape removeShape(int pos) {
        // The assignment specifically asks to check if a shape exists at this position.
        // If I don't check this, my program will crash with an IndexOutOfBoundsException.
        if (pos >= 0 && pos < listofShapes.size()) {
            Shape removed = listofShapes.remove(pos);
            System.out.println("Shape at position " + pos + " removed.");
            return removed;
        } else {
            // I print an error message instead of letting the program crash.
            System.out.println("Error: No shape found at position " + pos + ".");
            return null;
        }
    }

    public Shape getShape(int pos) {
        // Same safety check as removeShape. I have to make sure the position is valid.
        if (pos >= 0 && pos < listofShapes.size()) {
            return listofShapes.get(pos);
        } else {
            System.out.println("Error: No shape found at position " + pos + ".");
            return null;
        }
    }

    public void translateShapes(int dx, int dy) {
        // A simple for loop to go through all shapes in my list and move them.
        for (int i = 0; i < listofShapes.size(); i++) {
            listofShapes.get(i).translate(dx, dy);
        }
    }

    public void scale(int factor, boolean sign) {
        // Looping through every shape in my list and scaling it.
        for (int i = 0; i < listofShapes.size(); i++) {
            listofShapes.get(i).scale(factor, sign);
        }
    }

    public double area(int pos) {
        // Instead of writing the safety check again, I just call my getShape method.
        // This is a great way to reuse my code.
        Shape s = getShape(pos);
        if (s != null) {
            return s.getArea();
        }
        return 0.0;
    }

    public double perimeter(int pos) {
        // Reusing getShape here as well.
        Shape s = getShape(pos);
        if (s != null) {
            return s.getPerimeter();
        }
        return 0.0;
    }

    public int getNumberOfShapes() {
        // Returns the total number of shapes currently in the list.
        return listofShapes.size();
    }

    public String display() {
        // If the list is empty, I want to inform the user instead of showing a blank screen.
        if (listofShapes.isEmpty()) {
            return "The shape list is currently empty.";
        }

        // I'm building a string piece by piece.
        String result = "--- All Shapes in the List ---\n";
        for (int i = 0; i < listofShapes.size(); i++) {
            result += "Position " + i + ": " + listofShapes.get(i).display() + "\n";
        }
        return result;
    }
}