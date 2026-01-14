import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

       int[] coins = new int[n];
       for(int i = 0; i < n; i++) {
           coins[i] = Integer.parseInt(br.readLine());
       }

       int[] dp = new int[k+1];
       Arrays.fill(dp, 1000000);
       dp[0] = 0;

       for(int coin:coins) {
           for(int j = coin; j <= k; j++) {
               dp[j] = Math.min(dp[j], dp[j-coin]+1);
           }
       }

       if(dp[k]!=1000000) {
           System.out.println(dp[k]);
       } else {
           System.out.println("-1");
       }
    }
}
