import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];

        for(int i=1;i<=K;i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int T  = Integer.parseInt(st.nextToken());

            for(int j=0;j<=N;j++) {
                if(j-T >= 0) {
                    dp[j][i] = Math.max(dp[j][i-1], dp[j-T][i-1] + I);
                } else {
                    dp[j][i] = dp[j][i-1];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
