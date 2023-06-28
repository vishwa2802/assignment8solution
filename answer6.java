
import java.util.ArrayList;
import java.util.List;

public class AnagramIndices {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pCharCount = new int[26];
        int[] windowCharCount = new int[26];

        // Count the frequency of characters in p
        for (char c : p.toCharArray()) {
            pCharCount[c - 'a']++;
        }

        // Initialize the window
        for (int i = 0; i < p.length(); i++) {
            windowCharCount[s.charAt(i) - 'a']++;
        }

        // Slide the window over s
        for (int i = 0; i <= s.length() - p.length(); i++) {
            // Check if the window is an anagram of p
            if (isAnagram(windowCharCount, pCharCount)) {
                result.add(i);
            }

            // Slide the window by one position to the right
            if (i < s.length() - p.length()) {
                windowCharCount[s.charAt(i) - 'a']--;
                windowCharCount[s.charAt(i + p.length()) - 'a']++;
            }
        }

        return result;
    }

    public static boolean isAnagram(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> indices = findAnagrams(s, p);
        System.out.println("Indices of p's anagrams in s: " + indices);
    }
}
