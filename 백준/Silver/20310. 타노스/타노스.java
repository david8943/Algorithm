import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length();
        int zero = 0;
        for(int i=0;i<input.length();i++) {
            if(input.charAt(i)=='0') {
                zero++;
            }
        }
        StringBuilder sb = new StringBuilder();

        int one = N-zero;

        int zeroCount = 0;
        int oneCount = 0;

        for(int i=0;i<N;i++) {
            if(input.charAt(i)=='1') {
                oneCount++;
            } else {
                zeroCount++;
            }

            if(zeroCount<=zero/2 && input.charAt(i)=='0') {
                sb.append('0');
            }
            if(oneCount>one/2 && input.charAt(i)=='1') {
                sb.append('1');
            }
        }

        System.out.println(sb.toString());
    }
}
