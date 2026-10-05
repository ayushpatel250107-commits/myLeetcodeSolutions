class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int left = 0;
        int right = n - 1;
        long totalCost = 0;

        for (int i = 0; i < candidates; i++) {
            if (left <= right) {
                pq.offer(new int[] { costs[left], left });
                left++;
            }
        }

        for (int i = 0; i < candidates; i++) {
            if (left <= right) {
                pq.offer(new int[] { costs[right], right });
                right--;
            }
        }

        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            totalCost += curr[0];
            int idx = curr[1];

            if (left <= right) {
                if (idx <= left) {
                    pq.offer(new int[] { costs[left], left });
                    left++;
                } else {
                    pq.offer(new int[] { costs[right], right });
                    right--;
                }
            }
        }

        return totalCost;
    }
}
