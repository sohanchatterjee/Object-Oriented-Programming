//Sohan Chatterjee
//SSW 315 Lab 7 Triangle Class
//October 14, 2022
public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        side1 = 0.0;
        side2 = 0.0;
        side3 = 0.0;
    }

    public Triangle(double side1, double side2, double side3) {
        try {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } catch (NumberFormatException e) {
            System.out.println("Enter a double.");
        }
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double semiPerim = getPerimeter() / 2;
        return Math.sqrt(semiPerim * (semiPerim - getSide1()) * (semiPerim - getSide2()) * (semiPerim - getSide3()));
    }

    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    public boolean isEquilateral() {
        return (getSide1() == getSide2() && getSide2() == getSide3());
    }

    public boolean isIsosceles() {
        return (getSide1() == getSide2() || getSide1() == getSide3() || getSide2() == getSide3());
    }

    public boolean isScalene() {
        return (getSide1() != getSide2() && getSide1() != getSide3() && getSide2() != getSide3());
    }

    public String toString() {
        return "side 1: " + getSide1() + " side 2: " + getSide2() + " side 3: " + getSide3() + " " + super.toString();
    }
}
