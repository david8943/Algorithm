import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                } else {
                    if(dp[i][j+1]>dp[i+1][j]){
                        dp[i+1][j+1] = dp[i][j+1];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j];
                    }
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);

        if(dp[s1.length()][s2.length()]>0){
            StringBuilder sb = new StringBuilder();
            int i = s1.length();
            int j = s2.length();

            while(i>0 && j>0){
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    sb.append(s1.charAt(i-1));
                    i--;
                    j--;
                } else {
                    if(dp[i][j-1]>=dp[i-1][j]){
                        j--;
                    } else {
                        i--;
                    }
                }
            }

            System.out.println(sb.reverse().toString());
        }
    }
}
