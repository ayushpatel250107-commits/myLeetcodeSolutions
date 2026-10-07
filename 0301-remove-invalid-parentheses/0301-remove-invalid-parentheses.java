import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int leftRem = 0;
        int rightRem = 0;

        // Step 1: Calculate the minimum number of '(' and ')' to remove
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftRem++;
            } else if (ch == ')') {
                if (leftRem > 0) {
                    leftRem--; // Valid pair found, decrement left
                } else {
                    rightRem++; // Misplaced ')'
                }
            }
        }

        // Step 2: Backtrack to find all unique valid combinations
        dfs(s, 0, leftRem, rightRem, result);
        return result;
    }

    private void dfs(String s, int startIndex, int leftRem, int rightRem, List<String> result) {
        // Base case: If no more removals are needed, check if the current string is valid
        if (leftRem == 0 && rightRem == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // Optimization: Skip duplicates to avoid duplicate configurations in the result
            if (i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            char ch = s.charAt(i);
            // If it's a parenthesis, try removing it and recurse
            if (ch == '(' && leftRem > 0) {
                String nextStr = s.substring(0, i) + s.substring(i + 1);
                dfs(nextStr, i, leftRem - 1, rightRem, result);
            } else if (ch == ')' && rightRem > 0) {
                String nextStr = s.substring(0, i) + s.substring(i + 1);
                dfs(nextStr, i, leftRem, rightRem - 1, result);
            }
        }
    }

    // Helper method to check if a parenthesis string layout is valid
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) {
                    return false; // Found more ')' than '(' at this point
                }
            }
        }
        return count == 0;
    }
}
