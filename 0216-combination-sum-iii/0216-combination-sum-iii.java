import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int k, int remainingSum, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        // Base case: If we have picked exactly k elements and the remaining sum is 0, we found a valid combination
        if (currentCombination.size() == k && remainingSum == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        if (currentCombination.size() > k || remainingSum < 0) {
            return;
        }

        // Explore numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            // Choose the current number
            currentCombination.add(i);
         
            backtrack(k, remainingSum - i, i + 1, currentCombination, result);
        
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
