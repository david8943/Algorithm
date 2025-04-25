import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][10]; // 오르막 수의 길이가 i이고 맨끝이 j인 경우

        for(int i=0;i<=9;i++) dp[1][i] = 1;

        for(int i=2;i<=n;i++) {
            for(int j=0;j<=9;j++) {
                for(int k=0;k<=j;k++) {
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        int result = 0;

        for(int i=0;i<=9;i++) result += dp[n][i];

        System.out.println(result%10007);
    }
}
