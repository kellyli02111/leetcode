// time: O(n)
// space: O(n)

class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int trappedSize = 0;
        int[] leftMax = new int[height.length];
        int[] trap = new int[height.length];
        leftMax[0] = 0;
        trap[height.length - 1] = 0;
        for (int i = 1; i < height.length; i++) {
            int max = height[i - 1];
            leftMax[i] = Math.max(max, leftMax[i - 1]);
        }
        int rightMax = 0;
        for (int j = height.length - 1; j >= 0; j--) {
            if (j != height.length - 1) {
                rightMax = Math.max(rightMax, height[j + 1]);
            }
            if (rightMax > height[j]
               && leftMax[j] > height[j]) {
                trappedSize += Math.min(leftMax[j], rightMax) - height[j];
            }
        }
        return trappedSize;
    }
}
