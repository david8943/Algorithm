import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int MOD = 1000000;
        int n = s.length();

        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            char one = s.charAt(i-1);
            char ten = s.charAt(i-2);

            if(one != '0') {
                dp[i] += dp[i-1];
                dp[i] %= MOD;
            }

            int temp = (ten-'0')*10 + (one-'0');
            if(temp>=10 && temp<=26) {
                dp[i] += dp[i-2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[n]);
    }
}
