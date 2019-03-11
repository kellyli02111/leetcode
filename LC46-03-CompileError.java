// iteration
// ConcurrentModificationException

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
        result.add(numsList);
        
        for (List<Integer> permutation: result) {      // ConcurrentModificationException
            for (int first = 0;  first < nums.length; first++) {
                for (int i = first; i < nums.length; i++) {
                    if (first != i) {
                        List<Integer> current = swapInArray(permutation, first, i);
                        result.add(current);
                    }
                }
            }
        }
        
        return result;
    }
    
    
    public List<Integer> swapInArray(List<Integer> nums, int index1, int index2) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.size(); i++) {
            if (i == index1) {
                result.add(nums.get(index2));
            }
            else if (i == index2) {
                result.add(nums.get(index2));
            }
            else {
                result.add(nums.get(i));
            }
        }
        return result;
    }
}
