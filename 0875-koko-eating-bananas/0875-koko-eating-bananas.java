class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        
        // Find the maximum pile size for the upper bound of binary search
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        int minSpeed = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                minSpeed = mid; // Try a slower speed
                right = mid - 1;
            } else {
                left = mid + 1; // Need a faster speed
            }
        }
        
        return minSpeed;
    }
    
    private boolean canFinish(int[] piles, int h, int k) {
        long hoursNeeded = 0;
        for (int pile : piles) {
            // Equivalent to Math.ceil((double) pile / k) without floating-point math
            hoursNeeded += (pile + k - 1) / k;
        }
        return hoursNeeded <= h;
    }
}
