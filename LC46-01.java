// time: O(n!)
// use the result of "LC31 - Next Permutation"

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> first = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            first.add(nums[i]);
        }
        result.add(first);
        int resultSize = nums.length;
        for (int k = resultSize - 1; k > 0; k--) {
            resultSize *= k;
        }
        for (int count = 1; count < resultSize; count++) {
            nextPermutation(nums);
            List<Integer> next = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                next.add(nums[i]);
            }
            result.add(next);
        }
        return result;
    }
    
    public void nextPermutation(int[] nums) {
        int end = nums.length - 1;
        int start = end;
        while (start >= 0) {
            start = end - 1;
            if (nums[start] < nums[end]) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                break;
            }
            while (start >= 0 && nums[start] >= nums[start + 1]) {
                start--;
            }
            if (start < 0) {
                reverseArray(nums, start + 1, end);
            }
            else {
                int search = start + 1;
                while (search <= end) {
                    if (nums[search] <= nums[start]) {
                        break;
                    }
                    else {
                        search++;
                    }
                }
                int temp = nums[start];
                nums[start] = nums[search - 1];
                nums[search - 1] = temp;
                reverseArray(nums, start + 1, end);
                break;
            }
        }
    }
    public void reverseArray(int[] nums, int start, int end) {
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            int temp = nums[i + start];
            nums[i + start] = nums[end - i];
            nums[end - i] = temp;
        }
    }
}
