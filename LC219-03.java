// time: O(n)
// space: O(n)
// one pass

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            else {
                int j = map.get(nums[i]);
                if (i - j <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
