class Solution {

    public int minPathSum(int[][] grid) {

        //return solve(grid, 0, 0);

        int m = grid.length;
        int n = grid[0].length;

        // first row
        for(int i=1; i<n; i++){
            grid[0][i] += grid[0][i-1];
        }

        // first column
        for(int i=1; i<m; i++){
            grid[i][0] += grid[i-1][0];
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j] += Math.min(
                    grid[i-1][j],
                    grid[i][j-1]
                );
            }
        }

        return grid[m-1][n-1];

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