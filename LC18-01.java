O(n^3)


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 4)
            return result;   
        Arrays.sort(nums);
        int d = 0;
        while (d < nums.length - 3)
        {
            List<List<Integer>> temp = new ArrayList();
            temp = threeSum(nums, target - nums[d], d + 1);
            if (temp.size() > 0)
            {
                for (List<Integer> triplet: temp)
                {
                    triplet.add(nums[d]);
                    result.add(triplet);
                }
            }
            d++;
            while (d < nums.length - 1 && nums[d]  == nums[d - 1])
                d++;
        }
        return result;
    }
    public List<List<Integer>> threeSum(int[] nums, int target, int start) {
        if (nums.length < 3)
            return null;
        List<List<Integer>> result = new ArrayList();
        int c = start; 
        while (c < nums.length - 2)
        {
            int a = c + 1;
            int b = nums.length - 1;
            while(a < b)
            {
                if (nums[a] + nums[b] == target - nums[c])
                {
                    List<Integer> pair = new ArrayList();
                    pair.add(nums[a]);
                    pair.add(nums[b]);
                    pair.add(nums[c]);
                    result.add(pair);
                    a++;
                    while (a < nums.length - 1 && nums[a] == nums[a - 1])
                        a++;
                }
                else if (nums[a] + nums[b] < target - nums[c])
                {
                    a++;
                    while (a < nums.length - 1 && nums[a] == nums[a - 1])
                        a++;
                }
                else
                {
                    b--;
                    while (b >= 0 && nums[b] == nums[b + 1])
                        b--;
                }
            }
            c++;
            while (c < nums.length - 1 && nums[c] == nums[c - 1])
                c++;
        }
        return result;
    }
}
