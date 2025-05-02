class Solution {
    static int findMax(int a, int b, int c){
        return Math.max(Math.max(a,b),c);
    }
    
    int solution(int[][] land) {
        int answer = 0;
        int depth = land.length;
        
        int[][] dp = new int[depth][4];
        
        for(int i=0;i<depth;i++){
            dp[i] = land[i].clone();
        }
        
        for(int i=1;i<depth;i++) {
            dp[i][0] += findMax(dp[i-1][1], dp[i-1][2], dp[i-1][3]);
            dp[i][1] += findMax(dp[i-1][0], dp[i-1][2], dp[i-1][3]);
            dp[i][2] += findMax(dp[i-1][0], dp[i-1][1], dp[i-1][3]);
            dp[i][3] += findMax(dp[i-1][0], dp[i-1][1], dp[i-1][2]);
        }
        
        for(int i=0;i<4;i++){
            answer = Math.max(answer, dp[depth-1][i]);
        }
        
        return answer;
    }
}