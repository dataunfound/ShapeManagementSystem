package OOB_Assignment;

import java.util.Scanner;

public class ShapeManagement {
    public static void main(String[] args) {
        // I created a Scanner object to read input from the console.
        Scanner input = new Scanner(System.in);

        // This is my main list that will store and manage all the shapes I create.
        ShapeList myShapes = new ShapeList();

        // I initialize choice to -1 so my while loop starts successfully.
        int choice = -1;

        System.out.println("Welcome to the Shape Management System!");

        // The program will keep showing this menu until the user types 0.
        while (choice != 0) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1: Add a shape");
            System.out.println("2: Remove a shape by position");
            System.out.println("3: Get information about a shape by position");
            System.out.println("4: Area and perimeter of a shape by position");
            System.out.println("5: Display information of all the shapes");
            System.out.println("6: Translate all the shapes");
            System.out.println("7: Scale all the shapes");
            System.out.println("0: Quit program");
            System.out.print("Please enter your choice: ");

            choice = input.nextInt();

            if (choice == 1) {
                // I created a sub menu here so the user can choose exactly which shape they want to build.
                System.out.println("\nWhich shape do you want to add?");
                System.out.println("1: Rectangle | 2: Square | 3: Circle | 4: Triangle");
                System.out.print("Shape choice: ");
                int shapeType = input.nextInt();

                // Every shape needs at least one starting point (x, y), so I ask for this first.
                System.out.print("Enter main X coordinate: ");
                int x = input.nextInt();
                System.out.print("Enter main Y coordinate: ");
                int y = input.nextInt();
                Coordinates c1 = new Coordinates(x, y);

                if (shapeType == 1) { // Rectangle
                    System.out.print("Enter width: ");
                    double w = input.nextDouble();
                    System.out.print("Enter length: ");
                    double l = input.nextDouble();

                    // I create the Rectangle object and add it to my list.
                    Rectangle r = new Rectangle(c1, w, l);
                    myShapes.addShape(r);
                }
                else if (shapeType == 2) { // Square
                    System.out.print("Enter side length: ");
                    double s = input.nextDouble();
                    Square sq = new Square(c1, s);
                    myShapes.addShape(sq);
                }
                else if (shapeType == 3) { // Circle
                    System.out.print("Enter radius: ");
                    double r = input.nextDouble();
                    Circle circ = new Circle(c1, r);
                    myShapes.addShape(circ);
                }
                else if (shapeType == 4) { // Triangle
                    // A triangle needs two extra points, so I have to ask the user for them.
                    System.out.print("Enter X for 2nd vertex: ");
                    int x2 = input.nextInt();
                    System.out.print("Enter Y for 2nd vertex: ");
                    int y2 = input.nextInt();
                    Coordinates c2 = new Coordinates(x2, y2);
                    System.out.print("Enter X for 3rd vertex: ");
                    int x3 = input.nextInt();
                    System.out.print("Enter Y for 3rd vertex: ");
                    int y3 = input.nextInt();
                    Coordinates c3 = new Coordinates(x3, y3);
                    Triangle t = new Triangle(c1, c2, c3);
                    myShapes.addShape(t);
                } else {
                    System.out.println("Invalid shape type selected. Returning to main menu.");
                }
            }
            else if (choice == 2) {
                System.out.print("Enter the position of the shape you want to remove: ");
                int pos = input.nextInt();
                // My removeShape method in ShapeList already handles the safety checks!
                myShapes.removeShape(pos);
            }
            else if (choice == 3) {
                System.out.print("Enter the position to get information: ");
                int pos = input.nextInt();
                Shape s = myShapes.getShape(pos);
                if (s != null) {
                    System.out.println(s.display());
                }
            }
            else if (choice == 4) {
                System.out.print("Enter the position for area and perimeter: ");
                int pos = input.nextInt();
                Shape s = myShapes.getShape(pos);
                // I must check if the shape is not null before trying to print its area.
                if (s != null) {
                    System.out.println("Area: " + myShapes.area(pos));
                    System.out.println("Perimeter: " + myShapes.perimeter(pos));
                }
            }
            else if (choice == 5) {
                // Displays all shapes currently stored in my list.
                System.out.println(myShapes.display());
            }
            else if (choice == 6) {
                System.out.print("Enter X translation (dx): ");
                int dx = input.nextInt();
                System.out.print("Enter Y translation (dy): ");
                int dy = input.nextInt();
                myShapes.translateShapes(dx, dy);
                System.out.println("All shapes have been translated.");
            }
            else if (choice == 7) {
                System.out.print("Enter scaling factor: ");
                int factor = input.nextInt();
                System.out.print("Enter 'true' to multiply or 'false' to divide: ");
                boolean sign = input.nextBoolean();
                myShapes.scale(factor, sign);
                System.out.println("All shapes have been scaled.");
            }
            else if (choice == 0) {
                System.out.println("Saving data and exiting program. Goodbye!");
            }
            else {
                // If the user types 8 or 9, my program won't crash, it will just ask again.
                System.out.println("Invalid choice. Please select a valid number from the menu.");
            }
        }

        // It's a good practice to close the scanner to prevent memory leaks.
        input.close();
    }
}
