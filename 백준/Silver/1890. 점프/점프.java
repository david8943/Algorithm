import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int dist = map[i][j];

                if(dist>0) {
                    if (i + dist < n) dp[i + dist][j] += dp[i][j];
                    if (j + dist < n) dp[i][j + dist] += dp[i][j];
                }
            }
        }

//        for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n-1][n-1]);
    }
}
