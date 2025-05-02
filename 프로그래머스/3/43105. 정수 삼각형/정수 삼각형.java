class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int depth = triangle.length;
        
        int[][] dp = new int[depth][depth];
        dp[0][0] = triangle[0][0];
        
        for(int i=1;i<depth;i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for(int j=1;j<i;j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        for(int i=0;i<depth;i++) answer = Math.max(answer, dp[depth-1][i]);
        
        return answer;
    }
}