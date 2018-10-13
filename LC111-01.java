// O(n^2)

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        if (height.length < 2)
        {
            return max;
        }
        for (int i = 0; i < height.length - 1; i++)
        {
            for (int j = i+1; j < height.length; j++)
            {
                int area = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
                max = area > max ? area : max;
            }
        }
        return max;
    }
}
