//Sohan Chatterjee
//SSW 315 Lab 6 MyInteger 
//October 06, 2022
public class MyInteger {
    private int value;

    public MyInteger() {
        this.value = 0;
    }

    public MyInteger(int value) {
        this.value = value;
    }

    public MyInteger(String value) {
        this.value = parseInt(value);
    }

    public MyInteger(char[] value) {
        this.value = parseInt(value);
    }

    public int get() {
        return value;
    }

    public boolean set(int val) {
        this.value = val;
        return (this.value == val);
    }

    public boolean set(String val) {
        return set(parseInt(val));
    }

    public boolean set(char[] val) {
        return set(parseInt(val));
    }

    public boolean isEven() {
        return (isEven(this.value));
    }

    public boolean isEven(int val) {
        if (val % 2 == 0)
            return true;
        return false;
    }

    public boolean isEven(MyInteger val) {
        return (isEven(val.get()));
    }

    public boolean isOdd() {
        return (isOdd(this.value));
    }

    public boolean isOdd(int val) {
        if (isEven(val))
            return false;
        return true;
    }

    public boolean isOdd(MyInteger val) {
        return (isOdd(val.get()));
    }

    public boolean isPrime() {
        return isPrime(this.value);
    }

    public boolean isPrime(int val) {
        if (val == 1)
            return true;
        for (int i = 2; i < val; i++) {
            if (val % i == 0)
                return false;
        }
        return true;
    }

    public boolean isPrime(MyInteger val) {
        return isPrime(val.get());
    }

    public boolean equals(int val) {
        return (this.value == val);
    }

    public boolean equals(MyInteger val) {
        return (equals(val.get()));
    }

    public int parseInt(char[] val) {
        int result = 0;
        boolean negative = false;
        for (int i = 0; i < val.length; i++) {
            if (val[0] == '-')
                negative = true;
            result *= 10;
            result += val[i] - '0';
        }
        if (negative)
            return result * -1;
        return result;
    }

    public int parseInt(String val) {
        return parseInt(val.toCharArray());
    }
}