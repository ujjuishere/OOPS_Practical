import java.util.*;
abstract class Shape {
    double num1, num2;
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height  : ");
        num1 = sc.nextDouble();
        System.out.println("Enter width : ");
        num2 = sc.nextDouble();
    }
    abstract void compute_area();
}
class Triangle extends Shape {
    void compute_area() {
        double area = 0.5 * num1 * num2;
        System.out.println("The area of the triangle is: " + area + " unit square");
    }
}
class Rectangle extends Shape {
    void compute_area() {
        double area = num1 * num2;
        System.out.println("The area of the rectangle is: " + area + " unit square");
    }
}

class Circle extends Shape {
    double radius;
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius: ");
        radius = sc.nextDouble();
    }
    void compute_area() {
        double area = 3.14 * radius * radius;
        System.out.println("The area of the circle is: " + area + " unit square");
    }
}
class Square extends Shape {
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side length: ");
        num1 = sc.nextDouble();
    }
    void compute_area() {
        double area = num1 * num1;
        System.out.println("The area of the square is: " + area + " unit square");
    }
}

public class area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape t = new Triangle();
        Shape r = new Rectangle();
        Shape c = new Circle();
        Shape s = new Square();
        int choice;
        do {
            System.out.println("MENU");
            System.out.println("1. TRIANGLE");
            System.out.println("2. RECTANGLE");
            System.out.println("3. CIRCLE");
            System.out.println("4. SQUARE");
            System.out.println("0. EXIT");
            System.out.print("Enter your CHOICE: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    t.input();
                    t.compute_area();
                    break;
                case 2:
                    r.input();
                    r.compute_area();
                    break;
                case 3:
                    c.input();
                    c.compute_area();
                    break;
                case 4:
                    s.input();
                    s.compute_area();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        } 
        while (choice != 0);
        sc.close();
    }
}