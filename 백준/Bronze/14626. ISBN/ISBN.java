import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        int pos = -1;
        int res = -1;

        for(int i=0;i<13;i++) {
            if(s.charAt(i)!='*') {
                if(i%2==0) sum += (s.charAt(i)-'0');
                else sum += (s.charAt(i)-'0')*3;
            } else {
                pos = i;
            }
        }

        for (int i = 0; i <= 9; i++) {
            int tempSum = sum + i * ((pos % 2 == 0) ? 1 : 3);
            if (tempSum % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
