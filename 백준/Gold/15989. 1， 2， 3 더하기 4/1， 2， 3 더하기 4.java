import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            for(int i=0;i<=n/3;i++) {
                answer += (n - 3*i)/2 + 1;
            }
            System.out.println(answer);
        }
    }
}
