// O(m+n)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return Integer.MIN_VALUE;
        }
        if (nums1.length == 0 && nums2.length == 0) {
            return Integer.MIN_VALUE;
        }
        List<Integer> mergedNums = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mergedNums.add(nums1[i]);
                i++;
            }
            else {
                mergedNums.add(nums2[j]);
                j++;
            }
        }
        while (i < nums1.length) {
            mergedNums.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            mergedNums.add(nums2[j]);
            j++;
        }
        
        int total = nums1.length + nums2.length;
        double result = 0.0;
        if (total % 2 == 0) {
            result = ((double)mergedNums.get(total / 2) + (double)mergedNums.get(total / 2 - 1)) / 2;
        }
        else {
            result = mergedNums.get((total - 1) / 2);
        }
        return result;
        
    }
}
