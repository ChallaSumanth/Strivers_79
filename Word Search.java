class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word.charAt(0))
                    if(check(board, word, i, j, 0, visited))
                        return true;
            }
        }
        return false;
    }
    private boolean check(char[][] board, String word, int i, int j, int index, boolean[][] visited)
    {
        if(index == word.length())
            return true;
        
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j] || board[i][j] != word.charAt(index))   
            return false;
        
        visited[i][j] = true;

        if(check(board, word, i, j + 1, index + 1, visited) || 
           check(board, word, i, j - 1, index + 1, visited) ||
           check(board, word, i - 1, j, index + 1, visited) ||
           check(board, word, i + 1, j, index + 1, visited)
        )
            return true;

        visited[i][j] = false;
        return false;
    }

        
}