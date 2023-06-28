import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int currentCount = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentCount = currentCount * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(currentCount);
                stringStack.push(currentString);
                currentCount = 0;
                currentString = "";
            } else if (ch == ']') {
                int count = countStack.pop();
                StringBuilder sb = new StringBuilder(stringStack.pop());
                for (int i = 0; i < count; i++) {
                    sb.append(currentString);
                }
                currentString = sb.toString();
            } else {
                currentString += ch;
            }
        }

        return currentString;
    }

    public static void main(String[] args) {
        String encodedString = "3[a]2[bc]]";
        String decodedString = decodeString(encodedString);
        System.out.println("Decoded string: " + decodedString);
    }
}
