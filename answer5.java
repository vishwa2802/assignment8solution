public class StringCompression {
    public static int compress(char[] chars) {
        int index = 0;  // Index to track the position in the modified array

        int i = 0;
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count the number of consecutive occurrences of currentChar
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            // Store the character at the current index
            chars[index] = currentChar;
            index++;

            // If the count is greater than 1, store the count as characters
            if (count > 1) {
                String countString = String.valueOf(count);
                for (char c : countString.toCharArray()) {
                    chars[index] = c;
                    index++;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = compress(chars);

        System.out.println("New length of the array: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}
