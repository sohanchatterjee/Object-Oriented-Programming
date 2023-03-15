import org.junit.Test;

//Sohan Chatterjee
//SSW 315 Lab 6 My Integer Test
//October 06, 2022
import static org.junit.Assert.*;

public class MyIntegerTest {
    @Test
    public void testGet() {
        MyInteger testInt = new MyInteger(4);
        assertEquals(4, testInt.get());
    }

    @Test
    public void testSet() {
        MyInteger testInt = new MyInteger(0);
        assertTrue("The value was not set properly", testInt.set(4));
    }

    @Test
    public void testSetString() {
        MyInteger testInt = new MyInteger("0");
        assertTrue("The value was not set properly", testInt.set("4"));
    }

    @Test
    public void testSetChar() {
        MyInteger testInt = new MyInteger('0');
        assertTrue("The value was not set properly", testInt.set('4'));
    }

    @Test
    public void testIsEven() {
        MyInteger testInt = new MyInteger(4);
        assertTrue("The value is not even", testInt.isEven());
    }

    @Test
    public void testIsEvenParameter() {
        MyInteger testInt = new MyInteger(4);
        assertTrue("The value is not even", testInt.isEven(4));
    }

    @Test
    public void testIsEvenClassParameter() {
        MyInteger testInt = new MyInteger(4);
        MyInteger testInt2 = new MyInteger(4);
        assertTrue("The value is not even", testInt.isEven(testInt2));
    }

    @Test
    public void testIsOdd() {
        MyInteger testInt = new MyInteger(3);
        assertTrue("The value is not odd", testInt.isOdd());
    }

    @Test
    public void testIsOddParameter() {
        MyInteger testInt = new MyInteger(3);
        assertTrue("The value is not odd", testInt.isOdd(3));
    }

    @Test
    public void testIsOddClassParameter() {
        MyInteger testInt = new MyInteger(3);
        MyInteger testInt2 = new MyInteger(3);
        assertTrue("The value is not odd", testInt.isOdd(testInt2));
    }

    @Test
    public void testIsPrime() {
        MyInteger testInt = new MyInteger(3);
        assertTrue("The value is not prime", testInt.isPrime());
    }

    @Test
    public void testIsPrimeParameter() {
        MyInteger testInt = new MyInteger(3);
        assertTrue("The value is not prime", testInt.isPrime(3));
    }

    @Test
    public void testIsPrimeClassParameter() {
        MyInteger testInt = new MyInteger(3);
        MyInteger testInt2 = new MyInteger(3);
        assertTrue("The value is not prime", testInt.isPrime(testInt2));
    }

    @Test
    public void testEquals() {
        MyInteger testInt = new MyInteger(3);
        assertTrue("The values are not equal", testInt.equals(3));
    }

    @Test
    public void testEqualsParameter() {
        MyInteger testInt = new MyInteger(3);
        MyInteger testInt2 = new MyInteger(3);
        assertTrue("The values are not equal", testInt.equals(testInt2));
    }

    @Test
    public void testParseChar() {
        MyInteger testInt = new MyInteger(3);
        assertEquals(3, testInt.parseInt(new char[] { '3' }));
    }

    @Test
    public void testParseString() {
        MyInteger testInt = new MyInteger(3);
        assertEquals(3, testInt.parseInt("3"));
    }
}
