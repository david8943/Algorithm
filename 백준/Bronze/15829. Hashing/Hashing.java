import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        long res = 0;

        for(int i = 0; i < n; i++){
            res += (s.charAt(i)-'a'+1)*(long)Math.pow(31,i)%1234567891;
        }

        System.out.println(res);
    }
}