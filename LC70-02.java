// fibonacci
// time: O(n)
// space: O(n)

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 2;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n - 1];
    }
}
