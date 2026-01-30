import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

            long answer = 0;
            int max = arr[N-1];

            for(int i=N-1;i>=0;i--) {
                if(arr[i] < max) {
                    answer += max-arr[i];
                } else {
                    max = arr[i];
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
