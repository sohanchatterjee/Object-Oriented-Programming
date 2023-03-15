
//Sohan Chatterjee
//SSW 315 Lab 8 Rectangle
//October 21, 2022
public class Rectangle extends Triangle {
    private double width;
    private double length;

    public Rectangle() {
        this.width = 0.0;
        this.length = 0.0;
    }

    public Rectangle(double width, double length) {
        try {
            this.width = width;
            this.length = length;
        } catch (NumberFormatException e) {
            System.out.println("Enter a double.");
        }
    }

    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return this.length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.getWidth() * this.getLength();
    }

    public double getPerimeter() {
        return (2 * getWidth()) + (2 * getLength());
    }

    public boolean isSquare() {
        return (getWidth() == getLength());
    }

    public boolean equals(Rectangle rectangle) {
        return ((this.getWidth() == rectangle.getWidth()) && (this.getLength() == rectangle.getLength()));
    }

    public String toString() {
        return "side 1: " + getWidth() + " side 2: " + getLength() + " " + super.toString();
    }
}
