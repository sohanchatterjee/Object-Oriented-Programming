
//Sohan Chatterjee
//SSW 315 Roman Numeral Test Class
//October 19, 2022
import org.junit.Test;
import static org.junit.Assert.*;

public class RomanNumberTest {
    RomanNumber testNum = new RomanNumber(53178);

    @Test
    public void testGetValue() {
        assertEquals(testNum.getValue(), 53178);
    }

    @Test
    public void testGetNumber() {
        assertEquals(testNum.getNumber(), "ↇMMMCLXXVIII");
    }

    @Test
    public void testParseValue() {
        assertEquals(RomanNumber.parseValue("ↇMMMCLXXVIII"), testNum.getValue());
    }

    @Test
    public void testParseNumber() {
        assertEquals(RomanNumber.parseNumber(53178), testNum.getNumber());
    }

    @Test
    public void testEqualsInt() {
        assertTrue("The values are not equal.", testNum.equals(53178));
    }

    @Test
    public void testEqualsString() {
        assertTrue("The values are not equal.", testNum.equals("ↇMMMCLXXVIII"));
    }

    @Test // 217149 + 53178 = 270327
    public void testAddition() {
        assertEquals(testNum.add("ↈↈↂↁMMCXLIX"), "ↈↈↇↂↂCCCXXVII");
    }

    @Test // 53178 - 12874 = 40304
    public void testSubtraction() {
        assertEquals(testNum.subtract("ↂMMDCCCLXXIV"), "ↂↇCCCIV");
    }

    @Test // 53178 * 3 = 159534
    public void testMultiplication() {
        assertEquals(testNum.multiply("III"), "ↈↇMↂDXXXIV");
    }

    @Test // 53178 / 9 = 5908
    public void testDivsion() {
        assertEquals(testNum.divide("IX"), "ↁCMVIII");
    }

    @Test // 217149 + 53178 = 270327
    public void testCalculate() {
        assertEquals(RomanNumber.calculate("ↇMMMCLXXVIII + ↈↈↂↁMMCXLIX"), "ↈↈↇↂↂCCCXXVII");
    }

    @Test // 217149 and 53178
    public void testMin() {
        assertEquals(testNum.min("ↈↈↂↁMMCXLIX"), testNum.getNumber());
    }

    @Test // 217149 and 53178
    public void testMax() {
        assertEquals(testNum.max("ↈↈↂↁMMCXLIX"), "ↈↈↂↁMMCXLIX");
    }
}
