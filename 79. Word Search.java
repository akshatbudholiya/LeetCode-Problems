class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) 
        {
            return false;
        }
          char[] wordArray = word.toCharArray();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArray[0] && dfs(board, i, j, wordArray, 0)) 
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, char[] wordArray, int index) 
    {
        if (index == wordArray.length) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != wordArray[index]) 
        {
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = ' /'; // Mark as visited
        
        boolean found = dfs(board, i + 1, j, wordArray, index + 1) ||
                        dfs(board, i - 1, j, wordArray, index + 1) ||
                        dfs(board, i, j + 1, wordArray, index + 1) ||
                        dfs(board, i, j - 1, wordArray, index + 1);
        
        board[i][j] = temp; // Reset the cell
        
        return found;
}
}
