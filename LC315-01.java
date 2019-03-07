// O(n^2)

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int index = 0; index < nums.length; index++) {
            int compare = index + 1;
            int count = 0;
            while (compare < nums.length) {
                if (nums[index] > nums[compare]) {
                    count++;
                }
                compare++;
            }
            result.add(count);
        }
        return result;
    }
}
