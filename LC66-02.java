class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[]{};
        }

        boolean allNine = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                allNine = false;
            }
        }
        int newSize = digits.length;
        if (allNine) {
            newSize++;
        }
        int[] result = new int[newSize];
        if (allNine) {
            result[0] = 1;
            for (int i = 1; i < digits.length; i++) {
                result[i] = 0;
            }
            return result;
        }
        else {
            for (int i = 0; i < digits.length; i++) {
                result[i] = digits[i];
            }
        }
        int carry = 1;
        int temp;
        for(int i = newSize - 1; i >= 0; i--){
            if(carry == 0) return result;
            temp = result[i] + carry;
            carry = temp / 10;
            result[i] = temp % 10;
        }

        return result;
    }
}
