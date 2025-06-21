import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[][] dp = new int[n][n]; // i에서 j까지

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++) {
            dp[i][i] = 0;
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int len=2; len <= n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i+len-1;
                for(int k=i; k<j; k++){
                    dp[i][j] = Math.min(dp[i][k]+dp[k+1][j]+arr[i][0]*arr[k][1]*arr[j][1], dp[i][j]);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}
