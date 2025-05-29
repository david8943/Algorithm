import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long c;

    static long pow(long base, long exponent) {
        if(exponent == 1) {
            return base % c;
        }

        long temp = pow(base, exponent / 2);

        if(exponent % 2 == 1) {
            return temp * temp % c * base % c;
        }

        return temp * temp % c;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a, b;
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(pow(a,b));
    }
}
