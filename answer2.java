import java.util.Stack;

public class ValidString {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        int starCount = 0;
        int openCount = 0;

        // Check the remaining characters in the stack
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
                openCount++;
            } else if (c == '*') {
                starCount++;
            }
        }

        // The number of open parentheses should be less than or equal to the number of stars
        // (since stars can be treated as either '(' or an empty string)
        return openCount <= starCount;
    }

    public static void main(String[] args) {
        String s = "()";
        boolean result = isValid(s);
        System.out.println(result);
    }
}
