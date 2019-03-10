// time: O(n^2)
// space: O(n)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean rowValid = true;
        boolean colValid = true;
        boolean boxValid = true;

        // row
        for (int i = 0; i < board.length; i++) {
            rowValid = isValidSudokuSubArray(board, i, 0, i, board[0].length - 1);
            if (!rowValid) {
                return false;
            }
        }
        // col
        for (int j = 0; j < board[0].length; j++) {
            colValid = isValidSudokuSubArray(board, 0, j, board.length - 1, j);
            if (!colValid) {
                return false;
            }
        }
        // box
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                boxValid = isValidSudokuSubArray(board, boxRow * 3, boxCol * 3, boxRow * 3 + 2, boxCol * 3 + 2);
                if (!boxValid) {
                    return false;
                }
            }
        }
        return rowValid && colValid && boxValid;
    }
    public boolean isValidSudokuSubArray(char[][] board, int startRow, int startCol, int endRow, int endCol) {
        Map<Character, Integer> counter = new HashMap<Character, Integer>();
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (board[i][j] != '.') {
                    if (!counter.containsKey(board[i][j])) {
                        counter.put(board[i][j], 1);
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
