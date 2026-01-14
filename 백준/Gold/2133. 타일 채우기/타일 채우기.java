import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[0] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-2]*3;

            for(int j=2;j<=i/2;j++){
                dp[i] += dp[i-2*j]*2;
            }
        }

        System.out.println(dp[n]);
    }
}
