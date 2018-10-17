// time: O(log(n))


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{-1,-1};
        for (int i = 0; i < numbers.length; i++)
        {
            // binary search target - numbers[i]
            int index2 = binarySearch(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (index2 != -1)
            {
                result[0] = i+1;
                result[1] = index2+1;
                break;
            }
        }
        return result;
    }
    public int binarySearch(int[] numbers, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (start == end)
        {
            if (numbers[start] == target)
                return start;
            else
                return -1;
        }
        
        if (numbers[mid] < target)
            return binarySearch(numbers, target, mid+1, end);
        else if (numbers[mid] == target)
            return mid;
        else
            return binarySearch(numbers, target, start, mid);
    } 
}
