
//Sohan Chatterjee
//SSW 315 Lab 8 Rectangle Test
//October 21, 2022
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class RectangleTest {
    Rectangle testRectangle = new Rectangle(3.0, 4.0);

    // Geometric Object Methods

    @Test
    public void testGetColor() {
        assertEquals("white", testRectangle.getColor());
    }

    @Test
    public void testSetColor() {
        testRectangle.setColor("green");
        assertEquals("green", testRectangle.getColor());
    }

    @Test
    public void testIsFilled() {
        assertFalse("The shape is filled.", testRectangle.isFilled());
    }

    @Test
    public void testSetFilled() {
        testRectangle.setFilled(true);
        assertTrue("The shape is not filled.", testRectangle.isFilled());
    }

    @Test
    public void testGetDateCreated() {
        assertEquals(LocalDate.now(), testRectangle.getDateCreated());
    }

    @Test
    public void testCompareTo() {
        Rectangle[] rectangles = {
                new Rectangle(3, 5),
                new Rectangle(13, 55),
                new Rectangle(7, 35),
                new Rectangle(1, 25),
                new Rectangle(100, 100) };
        java.util.Arrays.sort(rectangles);
        Rectangle[] desiredRectangles = {
                new Rectangle(3, 5),
                new Rectangle(1, 25),
                new Rectangle(7, 35),
                new Rectangle(13, 55),
                new Rectangle(100, 100) };

        assertEquals(0, rectangles[0].compareTo(desiredRectangles[0]));
        assertEquals(0, rectangles[1].compareTo(desiredRectangles[1]));
        assertEquals(0, rectangles[2].compareTo(desiredRectangles[2]));
        assertEquals(0, rectangles[3].compareTo(desiredRectangles[3]));
        assertEquals(0, rectangles[4].compareTo(desiredRectangles[4]));
    }

    @Test
    public void testTriangleCompareTo() {
        Triangle[] triangles = {
                new Triangle(3, 5, 7),
                new Triangle(13, 55, 7),
                new Triangle(7, 35, 7),
                new Triangle(1, 25, 7),
                new Triangle(100, 100, 7) };
        java.util.Arrays.sort(triangles);
        Triangle[] desiredTriangles = {
                new Triangle(3, 5, 7),
                new Triangle(1, 25, 7),
                new Triangle(7, 35, 7),
                new Triangle(13, 55, 7),
                new Triangle(100, 100, 7) };

        assertEquals(0, triangles[0].compareTo(desiredTriangles[0]));
        assertEquals(0, triangles[1].compareTo(desiredTriangles[1]));
        assertEquals(0, triangles[2].compareTo(desiredTriangles[2]));
        assertEquals(0, triangles[3].compareTo(desiredTriangles[3]));
        assertEquals(0, triangles[4].compareTo(desiredTriangles[4]));
    }

    // Triangle Class Methods

    @Test
    public void testGetSide1() {
        assertEquals(0.0, testRectangle.getSide1(), 0.01d);
    }

    @Test
    public void testGetSide2() {
        assertEquals(0.0, testRectangle.getSide2(), 0.01d);
    }

    @Test
    public void testGetSide3() {
        assertEquals(0.0, testRectangle.getSide3(), 0.01d);
    }

    @Test
    public void testSetSide1() {
        testRectangle.setSide1(4.0);
        assertEquals(4.0, testRectangle.getSide1(), 0.01d);
    }

    @Test
    public void testSetSide2() {
        testRectangle.setSide2(9.0);
        assertEquals(9.0, testRectangle.getSide2(), 0.01d);
    }

    @Test
    public void testSetSide3() {
        testRectangle.setSide3(11.0);
        assertEquals(11.0, testRectangle.getSide3(), 0.01d);
    }

    @Test
    public void testIsEquilateral() {
        assertTrue("The triangle is equilateral.", testRectangle.isEquilateral());
    }

    @Test
    public void testIsIsosceles() {
        assertTrue("The triangle is isosceles.", testRectangle.isIsosceles());
    }

    @Test
    public void testIsScalene() {
        assertFalse("The triangle is scalene.", testRectangle.isScalene());
    }

    // Rectangle Class Methods

    @Test
    public void testGetWidth() {
        assertEquals(3.0, testRectangle.getWidth(), 0.01d);
    }

    @Test
    public void testGetLength() {
        assertEquals(4.0, testRectangle.getLength(), 0.01d);
    }

    @Test
    public void testSetWidth() {
        testRectangle.setWidth(5.0);
        assertEquals(5.0, testRectangle.getWidth(), 0.01d);
    }

    @Test
    public void testSetLength() {
        testRectangle.setLength(7.0);
        assertEquals(7.0, testRectangle.getLength(), 0.01d);
    }

    @Test
    public void testGetArea() {
        assertEquals(12.0, testRectangle.getArea(), 0.01d);
    }

    @Test
    public void testGetPerimeter() {
        assertEquals(14.0, testRectangle.getPerimeter(), 0.01d);
    }

    @Test
    public void testIsSquare() {
        assertFalse("The rectangle is square.", testRectangle.isSquare());
    }

    @Test
    public void testEquals() {
        Rectangle secondRectangle = new Rectangle(3.0, 4.0);
        assertTrue("The rectangles are not equal.", testRectangle.equals(secondRectangle));
    }

    @Test
    public void testToString() {
        assertEquals(
                "side 1: " + testRectangle.getWidth() + " side 2: " + testRectangle.getLength() + " " + "side 1: "
                        + testRectangle.getSide1() + " side 2: " + testRectangle.getSide2() + " side 3: "
                        + testRectangle.getSide3() + " " + "created: " + testRectangle.getDateCreated() + ", color: "
                        + testRectangle.getColor() + " and filled: " + testRectangle.isFilled(),
                testRectangle.toString());
    }
}
