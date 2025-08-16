import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[k+1][n];

        for(int i=arr[0][0];i<=k;i++)
            dp[i][0] = arr[0][1];

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j < n; j++) {
                int w = arr[j][0];
                int v = arr[j][1];
                dp[i][j] = dp[i][j-1];
                if(i-w>=0 && dp[i][j]<dp[i-w][j-1]+v) {
                    dp[i][j] = dp[i-w][j-1]+v;
                }
            }
        }

        System.out.println(dp[k][n-1]);
    }
}
