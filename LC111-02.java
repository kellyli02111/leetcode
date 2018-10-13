// O(n)

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        if (height.length < 2)
        {
            return max;
        }
        int left = 0;
        int right = height.length - 1;
        while (left < right)
        {
            int area = (right - left) * (height[left] < height[right] ? height[left] : height[right]);
            max = area > max ? area : max;
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
