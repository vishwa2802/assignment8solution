public class StringSwap {
    public static boolean canBeEqualBySwapping(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return true;
        }

        int firstMismatch = -1;
        int secondMismatch = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstMismatch == -1) {
                    firstMismatch = i;
                } else if (secondMismatch == -1) {
                    secondMismatch = i;
                } else {
                    return false;  // More than two mismatches
                }
            }
        }

        if (firstMismatch == -1 || secondMismatch == -1) {
            return false;  // Less than two mismatches
        }

        return s.charAt(firstMismatch) == goal.charAt(secondMismatch) &&
               s.charAt(secondMismatch) == goal.charAt(firstMismatch);
    }

    public static void main(String[] args) {
        String s = "abcd";
        String goal = "cbad";
        boolean result = canBeEqualBySwapping(s, goal);
        System.out.println("Can be equal by swapping: " + result);
    }
}
