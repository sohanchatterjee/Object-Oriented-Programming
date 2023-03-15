//Sohan Chatterjee
//SSW 315 Roman Numeral Class
//October 19, 2022
public class RomanNumber {
    private int value;
    private String number;

    public RomanNumber(int value) {
        this.value = value;
        this.number = parseNumber(value);
    }

    public RomanNumber(String number) {
        this.number = number;
        this.value = parseValue(number);
    }

    public int getValue() {
        return value;
    }

    public String getNumber() {
        return number;
    }

    public static int parseValue(String num) {
        int total = 0;
        for (int i = 0; i < num.length(); i++) {
            int first = getNum(num.charAt(i));
            if (i + 1 < num.length()) {
                int second = getNum(num.charAt(i + 1));
                if (first >= second)
                    total += first;
                else
                    total -= first;
            } else
                total += first;
        }
        return total;
    }

    public static int getNum(char r) {
        switch (r) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'ↁ':
                return 5000;
            case 'ↂ':
                return 10000;
            case 'ↇ':
                return 50000;
            case 'ↈ':
                return 100000;
        }
        return -1;
    }

    public static String parseNumber(int num) {
        if (num < 1 || num > 300000)
            return "Enter a valid number.";
        String[] hundredthousands = { "", "ↈ", "ↈↈ", "ↈↈↈ" };
        String[] tenthousands = { "", "ↂ", "ↂↂ", "ↂↂↂ", "ↂↇ", "ↇ", "ↇↂ", "ↇↂↂ", "ↇↂↂↂ", "ↂↈ" };
        String[] thousands = { "", "M", "MM", "MMM", "Mↁ", "ↁ", "ↁM", "ↁMM", "ↁMMMM", "Mↂ" };
        String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        return hundredthousands[num / 100000] + tenthousands[(num % 100000) / 10000] + thousands[(num % 10000) / 1000]
                + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
    }

    public boolean equals(String num) {
        return (number.equals(num));
    }

    public boolean equals(int num) {
        return (value == num);
    }

    public String add(String num) {
        value += parseValue(num);
        number = parseNumber(value);
        return number;
    }

    public String subtract(String num) {
        value -= parseValue(num);
        number = parseNumber(value);
        return number;
    }

    public String multiply(String num) {
        value *= parseValue(num);
        number = parseNumber(value);
        return number;
    }

    public String divide(String num) {
        value /= parseValue(num);
        number = parseNumber(value);
        return number;
    }

    public static String calculate(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+') {
                int sum = parseValue(expression.substring(0, i))
                        + parseValue(expression.substring(i + 1, expression.length()));
                return parseNumber(sum);
            } else if (expression.charAt(i) == '-') {
                int difference = parseValue(expression.substring(0, i))
                        - parseValue(expression.substring(i + 1, expression.length()));
                return parseNumber(difference);
            } else if (expression.charAt(i) == '*') {
                int product = parseValue(expression.substring(0, i))
                        * parseValue(expression.substring(i + 1, expression.length()));
                return parseNumber(product);
            } else if (expression.charAt(i) == '/') {
                int quotient = parseValue(expression.substring(0, i))
                        / parseValue(expression.substring(i + 1, expression.length()));
                return parseNumber(quotient);
            }
        }
        return "Unable to complete the operation.";
    }

    public String min(String num) {
        if (parseValue(num) < value)
            return num;
        return number;
    }

    public String max(String num) {
        if (parseValue(num) > value)
            return num;
        return number;
    }
}
