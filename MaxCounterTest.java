
//Sohan Chatterjee
//SSW 315
//Max Counter Test Lab 4
//September 22, 2022
import org.junit.Test;

public class MaxCounterTest {
    @Test
    public void testParseValues() {
        System.out.println(MaxCounter.parseValues("3 5 2 0 5 5 5 -1"));
        System.out.println(MaxCounter.parseValues("3 6 5 4 2 -4 5 4 5 5"));
    }

    @Test
    public void testMaxCounter() {
        System.out.println(MaxCounter.maxCounter(MaxCounter.parseValues("3 5 2 0 5 5 5 -1")));
        System.out.println(MaxCounter.maxCounter(MaxCounter.parseValues("3 6 5 4 2 -4 5 4 5 5")));
    }
}
