class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
    int[][] grid = new int[N][N];   
    for (int i = 0; i < N; i++) {
        Arrays.fill(grid[i], N);
    }    
    for (int[] m : mines) {
        grid[m[0]][m[1]] = 0;
    }    
    for (int i = 0; i < N; i++) {
        for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
            grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));  // left direction
    /**              j is a column index, iterate from left to right
                     every time check how far left it can reach.
                     if grid[i][j] is 0, l needs to start over from 0 again, otherwise increment */
            grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));  // right direction
            /**   k is a column index, iterate from right to left
                    // every time check how far right it can reach.
                    // if grid[i][k] is 0, r needs to start over from 0 again, otherwise increment */
            grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));  // up direction
            /** j is a row index, iterate from top to bottom
                    // every time check how far up it can reach.
                    // if grid[j][i] is 0, u needs to start over from 0 again, otherwise increment */
            grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));  // down direction
            /* // k is a row index, iterate from bottom to top
                    // every time check how far down it can reach.
                    // if grid[k][i] is 0, d needs to start over from 0 again, otherwise increment*/
        }
    }    
    int res = 0;    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            res = Math.max(res, grid[i][j]);
        }
    }    
    return res;
}
}
/*For the left direction, i is a row index while j is a column index. For each row, j goes from left to right (increasing).

For the right direction, i is a row index while k is a column index. For each row, k goes from right to left (decreasing).

For the up direction, i is a column index while j is a row index. For each column, j goes from top to bottom (increasing).

For the down direction, i is a column index while k is a row index. For each column, k goes from bottom to top (decreasing).*/