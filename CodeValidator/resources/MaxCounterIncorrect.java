
//Sohan Chatterjee
//SSW 315
//Max Counter Lab 4
//September 22, 2022

public class MaxCounterIncorrect {
    static int[] maxCounter(int[] values) {
        int maxNum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > maxNum) {
                maxNum = values[i];
                count = 1;
            } else if (values[i] == maxNum)
                count++;
        }
        System.out.println("The largest number is " + maxNum);
        System.out.println("The occurrence count of the largest number is " + count);
        return values;
    }

    static int[] parseValues(String input) {
        int[] numberList = new int[input.length()];
        String[] numberStrList = input.split(" ");
        for (int i = 0; i < numberStrList.length; i++ {
            if (checkIntegerValue(numberStrList[i]))
                numberList[i] = Integer.parseInt(numberStrList[i]);
        }
        return numberList;
    }

    static boolean checkIntegerValue(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}