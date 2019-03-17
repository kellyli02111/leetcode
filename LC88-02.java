// time: O(m+n)
// space: O(m+n)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0 || nums2.length <= 0) {
            return;
        }
        int i = 0;
        int j = 0;
        int[] mergedArray = new int[m + n];
        while (i <= m && j <= n && i + j < m + n) {
            if (j == n) {
                mergedArray[i + j] = nums1[i];
                i++;
            }
            else if (i == m || nums1[i] > nums2[j]) {
                mergedArray[i + j] = nums2[j];
                j++;
            }
            else {
                mergedArray[i + j] = nums1[i];
                i++;
            }
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = mergedArray[k];
        }
    }
}
