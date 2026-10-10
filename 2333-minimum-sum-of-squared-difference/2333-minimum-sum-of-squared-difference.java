class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        // Since maximum element value is 10^5, max difference is 10^5
        int[] bucket = new int[100001]; 
        long k = (long) k1 + k2;
        long totalDiff = 0;
        int maxDiff = 0;

        // Populate the frequency bucket array
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                bucket[diff]++;
                totalDiff += diff;
                maxDiff = Math.max(maxDiff, diff);
            }
        }

        // Edge case: If total operations can reduce all differences to 0
        if (totalDiff <= k) {
            return 0;
        }

        // Process from the maximum difference downwards
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (bucket[d] > 0) {
                // Determine how many elements at difference 'd' we can reduce
                long take = Math.min((long) bucket[d], k);
                
                bucket[d] -= take;
                bucket[d - 1] += take;
                k -= take;
            }
        }

        // Calculate the final sum of squared differences
        long minSumSquare = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (bucket[d] > 0) {
                minSumSquare += (long) d * d * bucket[d];
            }
        }

        return minSumSquare;
    }
}
