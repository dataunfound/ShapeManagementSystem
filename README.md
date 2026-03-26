# Shape Management System

This is a console based Java application built for my Object-Oriented Programming course. It acts as a geometric shape manager, allowing users to create shapes, change their properties (like moving or resizing them), and calculate their area and perimeter.

## Features
- **Add/Remove Shapes:** Supports Rectangles, Squares, Circles, and Triangles.
- **List Shapes:** Displays all current shapes in memory with their specific coordinates and dimensions.
- **Mathematical Operations:** - **Translate:** Move shapes across the X and Y axes.
  - **Scale:** Increase or decrease the size of shapes by a specific factor.
  - **Calculate:** Get the exact area and perimeter of any selected shape.

## OOP Approach
The main focus of this assignment was applying core Object-Oriented principles to solve geometric problems:
- **Abstraction & Inheritance:** A base abstract `Shape` class defines the rules, while specific classes (like `Triangle`) extend it and provide their own math logic.
- **Polymorphism:** Methods like `getArea()` and `translate()` are overridden in subclasses to handle shape-specific formulas.
- **Composition:** X and Y positions are managed by a separate `Coordinates` class rather than scattering integer variables everywhere.
- **Encapsulation:** All dimensions are kept private and validated to prevent invalid inputs (like negative lengths or scaling by zero).

## How to Compile and Run
Make sure you have Java installed. Open your terminal, navigate to the folder containing the project, and run the following commands:

```bash
javac OOB_Assignment/*.java
java OOB_Assignment.ShapeManagement
