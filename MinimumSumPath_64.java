class Solution {

    public int minPathSum(int[][] grid) {

        return solve(grid, 0, 0);
    }

    int solve(int[][] grid, int i, int j) {

        int row = grid.length;
        int col = grid[0].length;

        // out of boundary
        if(i >= row || j >= col) {
            return Integer.MAX_VALUE;
        }

        // reached destination
        if(i == row - 1 && j == col - 1) {
            return grid[i][j];
        }

        int right = solve(grid, i, j + 1);
        int down  = solve(grid, i + 1, j);

        return Math.min(right, down) + grid[i][j];
    }
}