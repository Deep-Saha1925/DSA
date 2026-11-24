class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[] board = new int[n];
        solve(0, board, n);
        return count;
    }
}