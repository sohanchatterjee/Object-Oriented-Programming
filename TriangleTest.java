
//Sohan Chatterjee
//SSW 315 Lab 7 Triangle Test
//October 14, 2022
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class TriangleTest {
    Triangle testTriangle = new Triangle(3.0, 4.0, 5.0);

    @Test
    public void testGetColor() {
        assertEquals("white", testTriangle.getColor());
    }

    @Test
    public void testSetColor() {
        testTriangle.setColor("green");
        assertEquals("green", testTriangle.getColor());
    }

    @Test
    public void testIsFilled() {
        assertFalse("The shape is filled.", testTriangle.isFilled());
    }

    @Test
    public void testSetFilled() {
        testTriangle.setFilled(true);
        assertTrue("The shape is not filled.", testTriangle.isFilled());
    }

    @Test
    public void testGetDateCreated() {
        assertEquals(LocalDate.now(), testTriangle.getDateCreated());
    }

    @Test
    public void testGetSide1() {
        assertEquals(3.0, testTriangle.getSide1(), 0.01d);
    }

    @Test
    public void testGetSide2() {
        assertEquals(4.0, testTriangle.getSide2(), 0.01d);
    }

    @Test
    public void testGetSide3() {
        assertEquals(5.0, testTriangle.getSide3(), 0.01d);
    }

    @Test
    public void testSetSide1() {
        testTriangle.setSide1(4.0);
        assertEquals(4.0, testTriangle.getSide1(), 0.01d);
    }

    @Test
    public void testSetSide2() {
        testTriangle.setSide2(9.0);
        assertEquals(9.0, testTriangle.getSide2(), 0.01d);
    }

    @Test
    public void testSetSide3() {
        testTriangle.setSide3(11.0);
        assertEquals(11.0, testTriangle.getSide3(), 0.01d);
    }

    @Test
    public void testGetArea() {
        assertEquals(6.0, testTriangle.getArea(), 0.01d);
    }

    @Test
    public void testGetPerimeter() {
        assertEquals(12.0, testTriangle.getPerimeter(), 0.01d);
    }

    @Test
    public void testIsEquilateral() {
        assertFalse("The triangle is equilateral.", testTriangle.isEquilateral());
    }

    @Test
    public void testIsIsosceles() {
        assertFalse("The triangle is isosceles.", testTriangle.isIsosceles());
    }

    @Test
    public void testIsScalene() {
        assertTrue("The triangle is not scalene.", testTriangle.isScalene());
    }

    @Test
    public void testToString() {
        assertEquals("side 1: " + testTriangle.getSide1() + " side 2: " + testTriangle.getSide2() + " side 3: "
                + testTriangle.getSide3() + " " + "created: " + testTriangle.getDateCreated() + ", color: "
                + testTriangle.getColor() + " and filled: " + testTriangle.isFilled(), testTriangle.toString());
    }
}
