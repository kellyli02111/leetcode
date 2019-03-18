// time: O(n)
// space: O(n)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return false;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> index = new ArrayList<Integer>();
            if (!map.containsKey(nums[i])) {
                index.add(i);
                map.put(nums[i], index);
            }
            else {
                index = map.get(nums[i]);
                index.add(i);
                map.put(nums[i], index);
            }
        }
        for (Integer key: map.keySet()) {
            List<Integer> index = map.get(key);
            for (int i = 0; i < index.size() - 1; i++) {
                if (index.get(i + 1) - index.get(i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
