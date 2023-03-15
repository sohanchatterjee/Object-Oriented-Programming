
//Sohan Chatterjee
//SSW 315 Card Validator
//September 29, 2022
import java.util.Arrays;

public class CardValidator {
    public static boolean isValid(long number) {
        int count = 1;
        while (number > 10) {
            number %= 10;
            count++;
        }
        if (count < 13 || count > 16)
            return false;
        else {
            int[] cardNum = new int[count];
            for (int i = 0; i < count; i++) {
                cardNum[i] = (int) number % 10;
                number %= 10;
            }
            if (cardNum[0] != 4 || cardNum[0] != 5 || cardNum[0] != 37 || cardNum[0] != 6) {
                return false;
            }
            int sum = oddAddition(cardNum) + evenAddition(cardNum);
            if (sum % 10 != 0)
                return false;
            else
                return true;
        }
    }

    static int oddAddition(int[] cardNumbers) {
        int sum = 0;
        int[] oddPlaces = new int[cardNumbers.length / 2];
        if (cardNumbers.length % 2 != 0) {
            for (int i = cardNumbers.length; i > 0; i -= 2) {
                oddPlaces[i] = cardNumbers[i - 2];
            }
        } else {
            for (int i = cardNumbers.length; i > 0; i -= 2) {
                oddPlaces[i] = cardNumbers[i - 1];
            }
        }
        for (int i = 0; i < oddPlaces.length; i++) {
            sum += oddPlaces[i];
        }
        return sum;
    }

    static int evenAddition(int[] cardNumbers) {
        int length = 0;
        int sum = 0;
        if (cardNumbers.length % 2 != 0) {
            length = cardNumbers.length % 2 + 1;
            int[] evenPlaces = new int[length];
            for (int i = cardNumbers.length; i > 0; i -= 2) {
                evenPlaces[i] = cardNumbers[i - 1];
            }
            for (int i = 0; i < evenPlaces.length; i++) {
                evenPlaces[i] = evenPlaces[i] * 2;
                if (evenPlaces[i] > 9) {
                    evenPlaces[i] = (evenPlaces[i] % 10) + (evenPlaces[i] % 100);
                }
                sum += evenPlaces[i];
            }
        } else {
            length = cardNumbers.length % 2;
            int[] evenPlaces = new int[length];
            for (int i = cardNumbers.length; i > 0; i -= 2) {
                evenPlaces[i] = cardNumbers[i - 2];
            }
            for (int i = 0; i < evenPlaces.length; i++) {
                evenPlaces[i] = evenPlaces[i] * 2;
                if (evenPlaces[i] > 9) {
                    evenPlaces[i] = (evenPlaces[i] % 10) + (evenPlaces[i] % 100);
                }
                sum += evenPlaces[i];
            }
        }
        return sum;
    }
}