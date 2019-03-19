// time: O(n)
// space: O(1)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int number = Math.abs(nums[i]);
            if (nums[number - 1] > 0) {
                nums[number - 1] = -nums[number - 1];
            }
            else {
                result.add(number);
            }
        }
        return result;
    }
}
