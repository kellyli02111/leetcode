// add "first" flag

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 4)
            return result;  
        Arrays.sort(nums);
        HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                int key = nums[i] + nums[j];
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(i);
                pair.add(j);
                List<List<Integer>> values = new ArrayList();
                if (!map.containsKey(key))
                {
                    values.add(pair);
                    map.put(key, values);
                }
                else
                {
                    if (!map.get(key).contains(pair))
                    {
                        values = map.get(key);
                        values.add(pair);
                        map.put(key, values);
                    }
                }
            }
        }
        int a = 0;
        while (a < nums.length - 1)
        {
            int b = a + 1;
            while (b < nums.length)
            {   
                boolean first = true;
                int key = target - (nums[a] + nums[b]);
                if (map.containsKey(key))
                {
                    for (List<Integer> pair: map.get(key))
                    {
                        if (b < pair.get(0))
                        {
                            List<Integer> quadruplet = new ArrayList<Integer>();
                            quadruplet.add(nums[a]);
                            quadruplet.add(nums[b]);
                            quadruplet.add(nums[pair.get(0)]);
                            quadruplet.add(nums[pair.get(1)]);

                            if (!first && result.get(result.size() - 1).get(2) == nums[pair.get(0)])
                                continue;      
                            else
                            {
                                result.add(quadruplet);
                                first = false;
                            }
                            
                        }
                    }
                }
                b++;
                while (b < nums.length && nums[b] == nums[b - 1])
                    b++;
            }
            a++;
            while (a < b && nums[a] == nums[a - 1])
                a++;
        }
        return result;
    }
}
