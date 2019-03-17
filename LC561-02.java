// time:O(n)
// space: O(n)


public class Solution {
    public int arrayPairSum(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        // arr[i]代表第nums[i+10000]出现的次数
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            // d: flag表示前面一组数有没有剩相同的数给后一组数
            // i.e.: (a,a)(a,b) => d=1; (a,a)(b,b) => d=0
            d = (2 + arr[i + lim] - d) % 2;
        }
        return sum;
    }
} 
