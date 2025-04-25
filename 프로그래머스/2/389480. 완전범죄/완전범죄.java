class Solution {
    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        
        int[][] dp = new int[itemCount+1][m];
        
        for(int i=0;i<=itemCount;i++) {
            for(int j=0;j<m;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[0][0] = 0;
        
        for(int i=0;i<itemCount;i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];
            
            for(int j=0;j<m;j++) {
                if(dp[i][j] == Integer.MAX_VALUE) continue;
                
                int newATrace = dp[i][j] + aTrace;
                if(newATrace < n) {
                     dp[i+1][j] = Math.min(dp[i+1][j], newATrace);
                }
                
                int newBTrace = j + bTrace;
                if(newBTrace < m) {
                    dp[i+1][newBTrace] = Math.min(dp[i+1][newBTrace], dp[i][j]);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            result = Math.min(result, dp[itemCount][j]);
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}