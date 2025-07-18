import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n+1][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        arr[n][0] = arr[0][0];
        arr[n][1] = arr[0][1];

        double answer = 0;

        for(int i = 0; i < n; i++) {
            answer += arr[i][0] * arr[i+1][1]-arr[i+1][0]*arr[i][1];
        }
        answer /= 2;
        if(answer < 0) answer *= -1;
        answer = Math.round(answer*100)/100.0;
        System.out.printf("%.1f\n", answer);
    }
}
