import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] name = new String[N];
        int[] power = new int[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++) {
            int x = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N;
            int result = 0;

            while(left <= right) {
                int mid = (left+right)/2;

                if(power[mid] < x) {
                    left = mid + 1;
                } else if(power[mid] >= x) {
                    result = mid;
                    right = mid -1;
                }
            }
            sb.append(name[result]).append("\n");
        }

        System.out.println(sb.toString());
    }
}