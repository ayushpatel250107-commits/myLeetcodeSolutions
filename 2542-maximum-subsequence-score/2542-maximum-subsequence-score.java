class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i];
            arr[i][1] = nums1[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(arr[i][1]);
            sum += arr[i][1];

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                ans = Math.max(ans, sum * arr[i][0]);
            }
        }

        return ans;
    }
}