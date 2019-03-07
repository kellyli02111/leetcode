class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[]{};
        }
//         long number = 0;
//         boolean allNine = true;
//         for (int i = 0; i < digits.length; i++) {
//             number += digits[i] * ((long) Math.pow(10, (digits.length - i - 1)));
//             if (digits[i] != 9) {
//                 allNine = false;
//             }
//         }
//         number++;
        
//         int newSize = digits.length;
//         if (allNine) {
//             newSize++;
//         }
//         int[] result = new int[newSize];
//         for (int i = 0; i < newSize; i++) {
//             result[i] = (int) (number / ((long) Math.pow(10, (newSize - i - 1))));
//             number = number % ((long) Math.pow(10, (newSize - i - 1)));
//         } 
//         return result;
        
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
        int i = digits.length - 1;
        digits[i]++;
        while (i > 0) {
            i--;
            if (digits[i + 1] > 9) {
                result[i]++;
                result[i + 1] = 0;
            }
            else {

                result[i] = digits[i];
                if (i + 1 == digits.length - 1) {
                    result[i + 1]++;
                }
                break;
            }
            printArray(result);
        }

        return result;
    }
    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}
