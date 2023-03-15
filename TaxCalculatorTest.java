import org.junit.jupiter.api.Test;

public class TaxCalculatorTest {
    @Test
    public void testSingleLowIncome(){
        TaxCalculator.calculateTax(0, 10000);
    }

    @Test
    public void testSingleMiddleIncome(){
        TaxCalculator.calculateTax(0, 100000);
    }

    @Test
    public void testSingleHighIncome(){
        TaxCalculator.calculateTax(0, 700000);
    }

    @Test
    public void testMarriedJointLowIncome(){
        TaxCalculator.calculateTax(1, 10000);
    }

    @Test
    public void testMarriedJointMiddleIncome(){
        TaxCalculator.calculateTax(1, 100000);
    }

    @Test
    public void testMarriedJointHighIncome(){
        TaxCalculator.calculateTax(1, 700000);
    }

    @Test
    public void testMarriedSeparateLowIncome(){
        TaxCalculator.calculateTax(2, 10000);
    }

    @Test
    public void testMarriedSeparateMiddleIncome(){
        TaxCalculator.calculateTax(2, 100000);
    }
    
    @Test
    public void testMarriedSeparateHighIncome(){
        TaxCalculator.calculateTax(2, 700000);
    }

    @Test
    public void testHeadLowIncome(){
        TaxCalculator.calculateTax(3, 10000);
    }

    @Test
    public void testHeadMiddleIncome(){
        TaxCalculator.calculateTax(3, 100000);
    }
    
    @Test
    public void testHeadHighIncome(){
        TaxCalculator.calculateTax(3, 700000);
    }
}