import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int result = 0;

        while(n>0) {
            int num = (int) Math.pow(2, n-1);
            int tr = r/num;
            int tc = c/num;

            result += (tr*2+tc)*(int) Math.pow(2, 2*(n-1));

            r = r%num;
            c = c%num;

            n--;
        }

        System.out.println(result);
    }
}