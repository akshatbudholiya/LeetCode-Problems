class Solution {
    public int getMaximumGold(int[][] grid) {
         int maxGold = 0;
        int m = grid.length;
        int n = grid[0].length;

        // Iterate through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start exploring from this cell if it has gold
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, explore(grid, i, j, new boolean[m][n]));
                }
            }
        }
        return maxGold;
    }

    private int explore(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        // Base case: out of bounds or already visited or no gold in this cell
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }

        // Mark the cell as visited
        visited[i][j] = true;

        // Explore in all four directions
        int up = explore(grid, i - 1, j, visited);
        int down = explore(grid, i + 1, j, visited);
        int left = explore(grid, i, j - 1, visited);
        int right = explore(grid, i, j + 1, visited);

        // Choose the maximum amount of gold that can be collected
        int maxGold = grid[i][j] + Math.max(Math.max(up, down), Math.max(left, right));

        // Mark the cell as unvisited (backtrack)
        visited[i][j] = false;

        return maxGold;
    }
}
