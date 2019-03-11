// backtrack
// recursion

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> numsList = new ArrayList<Integer>();
        for (int k = 0; k < nums.length; k++) {
            numsList.add(nums[k]);
        }
        
        backtrack(numsList, result, 0);
        
        return result;
    }
    
    public void backtrack(List<Integer> nums, List<List<Integer>> result, int first) {
        if (first == nums.size()) {
            result.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < nums.size(); i++) {
            Collections.swap(nums, first, i);
            backtrack(nums, result, first + 1);
            Collections.swap(nums, first, i);
        }
    }
}
