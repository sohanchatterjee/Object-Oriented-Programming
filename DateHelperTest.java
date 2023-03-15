
//Sohan Chatterjee
//SSW 315 Date Helper Test Cases
//September 21, 2022
import org.junit.jupiter.api.Test;

public class DateHelperTest {
    @Test
    public void testGetMonth() {
        System.out.println(DateHelper.getMonth(3));
    }

    @Test
    public void testGetMonthStr() {
        System.out.println(DateHelper.getMonth("March"));
        System.out.println(DateHelper.getMonth("Augus"));
        System.out.println(DateHelper.getMonth("frebu"));
    }

    @Test
    public void testGetDay() {
        System.out.println(DateHelper.getDay(4));
        System.out.println(DateHelper.getDay(8));
    }

    @Test
    public void testGetDayStr() {
        System.out.println(DateHelper.getDay("tuesday"));
        System.out.println(DateHelper.getDay("satur"));
    }

    @Test
    public void testGetDate() {
        System.out.println(DateHelper.getDate(2022, 01, 20));
    }

    @Test
    public void testGetDateArray() {
        System.out.println(DateHelper.getDate("2022-01-20"));
        System.out.println(DateHelper.getDate("invalid"));
    }

    @Test
    public void testLeapYear() {
        System.out.println(DateHelper.isLeapYear(2012));
        System.out.println(DateHelper.isLeapYear(2011));
    }

    @Test
    public void testValidDate() {
        System.out.println(DateHelper.isValidDate(2022, 1, 20));
    }

    @Test
    public void testDayOfYear() {
        System.out.println(DateHelper.dayOfYear(2022, 1, 20));
        System.out.println(DateHelper.dayOfYear(2022, 9, 9));
    }

    @Test
    public void testDaysOfMonth() {
        System.out.println(DateHelper.daysOfMonth(2022, 1));
        System.out.println(DateHelper.daysOfMonth(2012, 2));
    }

    @Test
    public void testDayOfWeek() {
        System.out.println(DateHelper.dayOfWeek(2022, 1, 20));
        System.out.println(DateHelper.dayOfWeek(2021, 9, 17));
    }

    @Test
    public void testDaysBetween() {
        System.out.println(DateHelper.daysBetween(2022, 1, 20, 2022, 1, 22));
        System.out.println(DateHelper.daysBetween(2022, 1, 10, 2022, 9, 9));
    }

    @Test
    public void testRandomYear() {
        System.out.println(DateHelper.randomYear(1990, 2000));
        System.out.println(DateHelper.randomYear(2000));
        System.out.println(DateHelper.randomYear());
    }

    @Test
    public void testRandomMonth() {
        System.out.println(DateHelper.randomMonth());
    }

    @Test
    public void testRandomDay() {
        System.out.println(DateHelper.randomDay(2022, 1));
        System.out.println(DateHelper.randomDay(1));
        System.out.println(DateHelper.randomDay());
    }

    @Test
    public void testRandomDate() {
        System.out.println(DateHelper.randomDate());
    }
}