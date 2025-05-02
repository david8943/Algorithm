class Solution
{
    public int solution(int [][]board)
    {
        int row = board.length;
        int column = board[0].length;
        int [][] dp = new int[row][column];
        
        // dp[0] = board[0].clone();
        for(int i=0;i<column;i++) {
            dp[0][i] = board[0][i];
        }
        for(int i=0;i<row;i++) {
            dp[i][0] = board[i][0];
        }
        
        int answer = board[0][0];
        
        for(int i=1;i<row;i++) {
            for(int j=1;j<column;j++) {
                if(board[i][j]==1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;                             answer = Math.max(answer, dp[i][j]*dp[i][j]);
                }
            }
        }
        
        return answer;
    }
}