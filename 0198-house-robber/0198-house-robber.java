class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int prev2 = 0; // Represents the max money robbed up to 2 houses ago (dp[i-2])
        int prev1 = 0; // Represents the max money robbed up to the previous house (dp[i-1])
        
        for (int num : nums) {
            // At each house, choose the maximum between:
            // 1. Skipping this house: take the profit from the previous house (prev1)
            // 2. Robbing this house: take the profit from two houses ago (prev2) + current house money
            int current = Math.max(prev1, prev2 + num);
            
            // Move the pointers forward for the next iteration
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}
