// time: O(n)
// space: O(1)
// bit manipulation

class Solution {
    public int singleNumber(int[] nums) {
        // mask掩码
        // one, two, three分别代表nums[i]是1的bit出现的次数 % 3是1，2，3
        int one = 0;
        int two = 0;
        int three = 0;
        for(int i = 0; i < nums.length; i++){
            // three与上一轮结果无关，变向清零(无寄存)，零时变量
            // 如果上一轮two为1， nums[i]出现第3次时，three被标记为1 （进位）
            three = two & nums[i];
            // two与上一轮结果相关，先不清零（有寄存）
            // 如果上一轮two为1， nums[i]出现第2次时，two被标记为1 （进位）
            two |= one & nums[i];
            // one同two
            one |= nums[i];
            // 如果本轮one进位到two（two由0变为1），则将one变为0
            // 如果本轮one没有进位（two还是0），则one不变
            one &= ~two;
            // two同one
            two &= ~three;
        }
        return one;
    }
}
