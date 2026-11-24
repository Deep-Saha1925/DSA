class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[] board = new int[n];
        solve(0, board, n);
        return count;
    }

    boolean isSafe(int row, int col, int[] board) {

        for (int i = 0; i < row; i++) {

            // Same column
            if (board[i] == col) {
                return false;
            }

            // Same diagonal
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }
}