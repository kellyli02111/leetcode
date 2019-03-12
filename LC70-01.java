// mathematical

class Solution {
    public int climbStairs(int n) {
        long result = 0;
        if (n <= 0) {
            return 0;
        }
        int countTwo = n / 2;
        for (int i = 0; i <= countTwo; i++) {
            // result += factor(n - i) / (factor(n - i * 2) * factor(i));
            result += reducedFactor(n - i, n - i * 2, i);
           // System.out.println((n-i) + "," + (n-i * 2) + "," + i);
        }
        return (int) result;
    }
    public long reducedFactor(int n, int x1, int x2) {
        long result = 1;
        for (int i = n; i > Math.max(x1, x2); i--) {
            result *= i;
        }
        result /= factor(Math.min(x1, x2));
        return result;
    }
    public long factor(int n) {
        long result = n;
        if (n <= 1) {
            return 1;
        }
        for (int i = n - 1; i > 1; i--) {
            result *= i;
        }
        return result;
    }
}
