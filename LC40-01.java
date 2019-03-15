// DFS


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<Integer>();
        combinationSumDFSHelper(candidates, target, 0, combination, result);
        return result;
    }
    
    public void combinationSumDFSHelper(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            if (!result.contains(combination)) {
                result.add(new ArrayList<Integer>(combination));
            }
            return;
        }
        
         for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            combinationSumDFSHelper(candidates, target - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);
         }
    }
    
}
