import java.io.*;
import java.util.*;

public class Main {
    static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        if(n==sqrt*sqrt) return true;
        else return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = 999;
        }
        dp[0] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=(int)Math.sqrt(i);j++){
                if(i-j*j>=0){
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
