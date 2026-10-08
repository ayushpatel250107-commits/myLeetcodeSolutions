class Solution {
    public int tribonacci(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Initialize the first three numbers: T0, T1, T2
        int a = 0;
        int b = 1;
        int c = 1;

        // Iteratively compute up to the n-th Tribonacci number
        for (int i = 3; i <= n; i++) {
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }

        return c;
    }
}
