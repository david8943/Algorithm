import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger result = new BigInteger("1");

        for(int i=n;i>=n-m+1;i--) result = result.multiply(BigInteger.valueOf(i));
        for(int i=1;i<=m;i++) result = result.divide(BigInteger.valueOf(i));

        System.out.println(result);
    }
}
