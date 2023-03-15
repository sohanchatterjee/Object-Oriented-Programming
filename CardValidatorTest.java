
//Sohan Chatterjee
//SSW 315 Card Validator Test
//September 29, 2022
import org.junit.jupiter.api.Test;

public class CardValidatorTest {
    @Test
    public void testValidVisaCard() {
        CardValidator.isValid(4388576018410707L);
    }

    @Test
    public void testInvalidVisaCard() {
        CardValidator.isValid(4388576018402626L);
    }

    @Test
    public void testValidAMEXCard() {
        CardValidator.isValid(345213475560929L);
    }

    @Test
    public void testTooLittleNum() {
        CardValidator.isValid(34521347929L);
    }

    @Test
    public void testTooManyNum() {
        CardValidator.isValid(3452134739891987929L);
    }
}
