import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];

        dp[0][0] = Integer.parseInt(br.readLine());

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(j==0) dp[i][j] = dp[i-1][j] + temp;
                else if(i==j) dp[i][j] = dp[i-1][j-1] + temp;
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + temp;
            }
        }

        int result = 0;

        for(int i=0;i<n;i++) {
            result = Math.max(result, dp[n-1][i]);
        }

        System.out.println(result);
    }
}
