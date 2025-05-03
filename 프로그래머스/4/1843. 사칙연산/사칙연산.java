import java.util.*;

class Solution {
    public int solution(String arr[]) {
        List<Integer> numList = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++) {
            if(i%2==0){
                numList.add(Integer.parseInt(arr[i]));
            } else {
                operators.add(arr[i].charAt(0));    
            }
        }
        
        int n = numList.size();
        
        int[][][] dp = new int[n][n][2];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j][0] = Integer.MAX_VALUE; // 최소
                dp[i][j][1] = Integer.MIN_VALUE; // 최대
            }
        }
        
        for(int i=0;i<n;i++) {
            dp[i][i][0] = numList.get(i);
            dp[i][i][1] = numList.get(i);
        }
        
        for(int length=2;length<=n;length++) {
            for(int i=0;i<=n-length;i++) {
                int j = i+length-1;
                
                for(int k=i;k<j;k++){
                    char op = operators.get(k);
                    
                    int[] results = new int[4];
                    
                    if (op == '+') {
                        results[0] = dp[i][k][0] + dp[k+1][j][0];
                        results[1] = dp[i][k][0] + dp[k+1][j][1];
                        results[2] = dp[i][k][1] + dp[k+1][j][0];
                        results[3] = dp[i][k][1] + dp[k+1][j][1];
                    } else {  // op == '-'
                        results[0] = dp[i][k][0] - dp[k+1][j][1];
                        results[1] = dp[i][k][0] - dp[k+1][j][0];
                        results[2] = dp[i][k][1] - dp[k+1][j][1];
                        results[3] = dp[i][k][1] - dp[k+1][j][0];
                    }
                    
                    // 최소값과 최대값 업데이트
                    for (int r : results) {
                        dp[i][j][0] = Math.min(dp[i][j][0], r);
                        dp[i][j][1] = Math.max(dp[i][j][1], r);
                    }
                }
            }
        }
            
        return dp[0][n-1][1];
    }
}