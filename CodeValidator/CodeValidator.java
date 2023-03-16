
//Sohan Chatterjee
//SSW 315 Lab 10 Code Validator
//November 4, 2022
import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CodeValidator {
    private static boolean isValid(String line) {
        Stack<Character> grouping = new Stack<>();
        for (char c : line.toCharArray()) {
            switch (c) {
                case '(':
                    grouping.push(c);
                    break;
                case '{':
                    grouping.push(c);
                    break;
                case '[':
                    grouping.push(c);
                    break;
                case ')':
                    if (grouping.empty() || grouping.peek() != '(') {
                        System.out.println(
                                "The given character is " + c + ". " + "The top character is " + grouping.peek());
                        return false;
                    } else
                        grouping.pop();
                    break;
                case '}':
                    if (grouping.empty() || grouping.peek() != '{') {
                        System.out.println(
                                "The given character is " + c + ". " + "The top character is " + grouping.peek());
                        return false;
                    } else
                        grouping.pop();
                    break;
                case ']':
                    if (grouping.empty() || grouping.peek() != '[') {
                        System.out.println(
                                "The given character is " + c + ". " + "The top character is " + grouping.peek());
                        return false;
                    } else
                        grouping.pop();
                    break;
                case '\'':
                    if (grouping.empty())
                        grouping.push(c);
                    else if (grouping.peek() != '\'') {
                        if (grouping.search(c) == -1)
                            grouping.push(c);
                        else {
                            System.out.println(
                                    "The given character is " + c + ". " + "The top character is " + grouping.peek());
                            return false;
                        }
                    } else
                        grouping.pop();
                    break;
                case '\"':
                    if (grouping.empty())
                        grouping.push(c);
                    else if (grouping.peek() != '\"') {
                        if (grouping.search(c) == -1)
                            grouping.push(c);
                        else {
                            System.out.println(
                                    "The given character is " + c + ". " + "The top character is " + grouping.peek());
                            return false;
                        }
                    } else
                        grouping.pop();
                    break;
                case '/':
                    break;
            }
        }
        return grouping.isEmpty();
    }

    public static boolean checkFile(String path) throws FileNotFoundException {
        Scanner input = new Scanner(new File(path));
        int lineCount = 0;
        String fileString = "";

        while (input.hasNext()) {
            lineCount++;
            fileString += input.nextLine();
        }

        if (isValid(fileString)) {
            System.out.println("The code is valid.");
            return true;
        } else {
            System.out.println("The code is not valid. There is an error at line " + lineCount);
            return false;
        }

    }
}