// O(log(m+n))

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        double result = 0.0;

        if (total % 2 == 0) {
            result = ((double) findKthNum(nums1, nums2, total / 2, 0, 0) + (double) findKthNum(nums1, nums2, total / 2 + 1, 0, 0)) / 2;
        }
        else {
            result = findKthNum(nums1, nums2, total / 2 + 1, 0, 0);
        }
        return result;
    }
    public int findKthNum(int[] nums1, int[] nums2, int k, int start1, int start2) {
        if (nums1 == null || nums2 == null) {
            return Integer.MIN_VALUE;
        }
        
        if (nums1.length == 0 && nums2.length == 0) {
            return Integer.MIN_VALUE;
        }
        int result = Integer.MIN_VALUE;
        if (start1 == nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 == nums2.length) {
            return nums1[start1 + k - 1];
        }
        
        if (k == 1) {
            //result = Math.min(nums1[start1], nums2[start2]);
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + k / 2 - 1;
        if (i >= nums1.length) {
            i = nums1.length - 1;
        }
        int j = start2 + k / 2 - 1;
        if (j >= nums2.length) {
            j = nums2.length - 1;
        }
        while (k > 1) {

            if(nums1[i] > nums2[j]) {
                if (k/2 > nums2.length) {
                    k = k - nums2.length;
                }
                else {
                    k = k - k /2;
                }
                //result = findKthNum(nums1, nums2, k, start1, j + 1);
                return findKthNum(nums1, nums2, k, start1, j + 1);
            }
            else {
                if (k/2 > nums1.length) {
                    k = k - nums1.length;
                }
                else {
                    k = k - k /2;
                }
                //result = findKthNum(nums1, nums2, k, i + 1, start2);
                return findKthNum(nums1, nums2, k, i + 1, start2);
            }
        }
        return Integer.MIN_VALUE;
    }
}
