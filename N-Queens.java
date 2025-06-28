class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char [] a : board)
            Arrays.fill(a, '.');
        solve(0, board, ans);
        return ans;
    }

    private boolean isPossible(int row, int col, char[][] board)
    {
        int dupRow = row;
        int dupCol = col;
        while(row >= 0 && col >= 0)
        {
            if(board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(col >= 0)
        {
            if(board[row][col] == 'Q')
                return false;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(row < board.length && col >= 0)
        {
            if(board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
    private void solve(int col, char[][] board, List<List<String>> ans)
    {
        if(col == board.length)
        {
            ans.add(constructBoard(board));
            return;
        }
        for(int row = 0; row < board.length; row++)
        {
            if(isPossible(row, col, board))
            {
                 board[row][col] = 'Q';
                 solve(col + 1, board, ans);
                 board[row][col] = '.';
            }

        }
    }

    private List<String> constructBoard(char [][] board)
    {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++)
        {
            String eachRow = new String(board[i]);
            res.add(eachRow);
        }
        return res;
    }
}