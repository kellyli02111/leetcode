// time: O(n)
// space: O(1)

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int result = n1 + n2;
        for (int i = 2; i < n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
