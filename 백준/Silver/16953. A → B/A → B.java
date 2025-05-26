import java.io.*;
import java.util.*;

public class Main {
    static int result = -2;

    static void calc(long num, long aim, int cnt) {
        if(num==aim) {
            result = cnt;
            return;
        }

        if(num>aim) {
            return;
        }

        calc(num*2, aim, cnt+1);
        calc(num*10+1, aim, cnt+1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        calc(a, b, 0);

        System.out.println(result+1);
    }
}
