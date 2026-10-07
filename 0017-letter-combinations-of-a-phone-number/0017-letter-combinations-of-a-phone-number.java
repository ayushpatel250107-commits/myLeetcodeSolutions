import java.util.ArrayList;
import java.util.List;

class Solution {
    // Map digits 2-9 to their corresponding letters on a phone keypad
    private static final String[] PHONE_MAP = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case: if we processed all digits, add the combination to result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        char digit = digits.charAt(index);
        String letters = PHONE_MAP[digit - '0'];

        // Iterate through each letter and recurse
        for (char letter : letters.toCharArray()) {
            current.append(letter);         // Choose
            backtrack(result, current, digits, index + 1); // Explore
            current.deleteCharAt(current.length() - 1);    // Backtrack (un-choose)
        }
    }
}
