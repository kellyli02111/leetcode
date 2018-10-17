// time: O(n^2)
// time limit exceeded without removeDuplicates


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;
        nums = removeDuplicates(nums);
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
    
    public int[] removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return nums;
        Arrays.sort(nums);
        List<Integer> newNums = new ArrayList<Integer>();
        newNums.add(nums[0]);
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1])
            {
                newNums.add(nums[i]);
                counter = 1;
            }
            else
            {
                if (counter < 4)
                {
                    newNums.add(nums[i]);
                    counter++;
                }
            }
        }
        int length = newNums.size();
        int[] result = new int[length];
        int j = 0;
        for (int num: newNums) {
            result[j] = num;
            j++;
        }
        return result;
    }
    
    
    // print functions
    public void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(", ");
        }
        System.out.println();
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
