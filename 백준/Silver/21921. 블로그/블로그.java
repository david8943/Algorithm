import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[N-X+1];

        for(int i=0;i<X;i++) {
            res[0] += arr[i];
        }

        for(int i=1;i<N-X+1;i++) {
            res[i] = res[i-1] - arr[i-1] + arr[i+X-1];
        }

        int max = 0;
        int cnt = 0;
        for(int i=0;i<N-X+1;i++) {
            if(res[i]>max) {
                max = res[i];
                cnt = 1;
            } else if(res[i]==max) {
                cnt++;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
