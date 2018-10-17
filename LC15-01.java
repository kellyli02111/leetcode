// time: O(n^2)
// time limit exceeded


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;
        for (int i = 0; i < nums.length; i++)
        {
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
        }
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for (List<Integer> triplet: result) {
            Collections.sort(triplet);
            if (!set.contains(triplet))
                set.add(triplet);
        }
        List<List<Integer>> resultNoDuplicate = new ArrayList<>();
        for (List<Integer> triplet: set) {
            resultNoDuplicate.add(triplet);
        }
        return resultNoDuplicate;
    }
    public List<List<Integer>> twoSum(int[] nums, int start, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 2)
            return result;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = start; i < nums.length; i++)
        {
            if (!set.contains(sum - nums[i]))
                set.add(nums[i]);
            else
            {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(nums[i]);
                pair.add(sum - nums[i]);
                result.add(pair);
            }
        }
        return result;
    }
    public void printList(List<Integer> nums, int sum) {
        for (Integer num: nums) {
            System.out.print(num);
            System.out.print(", ");
        }
        System.out.println();
        System.out.print("sum = "+ Integer.toString(sum));
        System.out.println();
    }
}
