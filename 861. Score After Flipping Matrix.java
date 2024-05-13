class Solution {
    public int matrixScore(int[][] grid) {
     int m = grid.length;
        int n = grid[0].length;
        
        // Toggle rows to ensure leading element is '1'
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                toggleRow(grid, i);
            }
        }
        
        // Toggle columns to maximize score
        for (int j = 1; j < n; j++) {
            int countOnes = 0;
            for (int i = 0; i < m; i++) {
                countOnes += grid[i][j];
            }
            if (countOnes < m - countOnes) {
                toggleColumn(grid, j);
            }
        }
        
        // Calculate the score
        int score = 0;
        for (int i = 0; i < m; i++) {
            int rowValue = 0;
            for (int j = 0; j < n; j++) {
                rowValue = rowValue * 2 + grid[i][j];
            }
            score += rowValue;
        }
        
        return score;   
    }
     private void toggleRow(int[][] grid, int rowIndex) {
        for (int j = 0; j < grid[0].length; j++) {
            grid[rowIndex][j] ^= 1;
        }
    }
    
    private void toggleColumn(int[][] grid, int colIndex) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][colIndex] ^= 1;
        }
    }
}
