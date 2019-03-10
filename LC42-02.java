// time: O(n)
// space: O(1)
// two pointers

class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int trappedSize = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }
                else {
                    trappedSize += leftMax - height[left];
                }
                left++;
            }
            else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }
                else {
                    trappedSize += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedSize;
    }
}
