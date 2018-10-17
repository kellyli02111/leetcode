// time: O(n^2) (more efficient than using HashMap


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++)
        {
            // trim
            if(nums[i] > 0) return result;
            List<List<Integer>> pairs = new ArrayList<>();
            pairs = twoSum(nums, i+1, -nums[i]);
            if (pairs.size() != 0)
            {
                for (List<Integer> pair: pairs)
                {
                    pair.add(nums[i]);
                    result.add(pair);
                }
            }
            while (i < nums.length - 2 && nums[i+1] == nums[i])
                i++;
        }
        return result;
    }
    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 2)
            return result;
        int end = nums.length - 1;
        Set<Integer> set = new HashSet<Integer>();
        while (start < end)
        {
            int sum = nums[start] + nums[end];
            if (sum == target) 
            {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(nums[start]);
                pair.add(nums[end]);
                result.add(pair);
                start++;
                while (nums[start - 1] == nums[start] && start < end)
                    start++;
            }
            else if (sum > target)
            {
                end--;
                while (nums[end + 1] == nums[end] && end > start)
                    end--;
            }
            else
            {
                start++;
                while (nums[start - 1] == nums[start] && start < end)
                    start++;
            }
        }
        return result;
    }
}
