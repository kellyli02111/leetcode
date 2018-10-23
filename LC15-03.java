// O(n^2)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;
        Arrays.sort(nums);
        int a = 0;
        while (nums[a] <= 0 && a < nums.length - 2)
        {
            int b = a + 1;
            int c = nums.length - 1;
            while (b < c)
            {
                int sum = nums[b] + nums[c];
                if (sum == -nums[a])
                {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[a]);
                    triplet.add(nums[b]);
                    triplet.add(nums[c]);
                    result.add(triplet);
                    b++;
                    while (nums[b - 1] == nums[b] && b < c)
                        b++;
                }
                else if (sum > -nums[a])
                {
                    c--;
                    while (nums[c + 1] == nums[c] && c > b)
                        c--;
                }

                else
                {
                    b++;
                    while (nums[b - 1] == nums[b] && b < c)
                        b++;
                }
            }
            
            while (a < nums.length - 2 && nums[a+1] == nums[a])
                a++;
            a++;
        }

        return result;
    }
}
