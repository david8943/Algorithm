import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        while(b!=0){
            int temp = b;
            b = a%b;
            a= temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int M=0, N=0, x=0, y=0;

        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int result = -1;

            int maxYear = lcm(M, N);
            for(int i=x;i<=maxYear;i+=M) {
                int ny = i%N;
                if(ny==0)
                    ny=N;

                if(ny == y){
                    result = i;
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
