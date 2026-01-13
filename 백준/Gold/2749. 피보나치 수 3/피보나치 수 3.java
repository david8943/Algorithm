import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int m = 1000000;
        int period = 1500000;

        int target = (int) (n%period);

        int[] dp = new int[target+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= target; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%m;
        }

        System.out.println(dp[target]);
    }
}
