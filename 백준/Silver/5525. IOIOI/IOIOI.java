import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        // 특정 지점부터 I 이후 OI가 몇개 반복되는지 체크. 8개인데 P3이라면 8-3+1

        int result = 0;
        int i = 0;

        while(i<m){
            if(s.charAt(i)=='I'){
                int temp = 0;
                i++;
                while(i+1<m && s.charAt(i)=='O' && s.charAt(i+1)=='I'){
                    temp++;
                    i+=2;
                }
                if(temp>=n) result+=(temp-n+1);
            } else {
                i++;
            }
        }
        System.out.println(result);
    }
}
