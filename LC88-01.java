//

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0 || nums2.length <= 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        for (int i = m; i < m + n; i++) {
            int current = i;
            while (current > 0 && nums1[current] < nums1[current - 1]) {
                int temp = nums1[current];
                nums1[current] = nums1[current - 1];
                nums1[current - 1] = temp;
                current--;
            }
        }
    }
}
