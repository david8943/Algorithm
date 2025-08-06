import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        int[] arr = new int[k];
        int max = 0;

        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) max = arr[i];
        }

        long start = 1;
        long end = max;
        long answer = 0;

        while(start <= end) {
            long mid = (start+end)/2;

            long temp = 0;
            for(int i=0;i<k;i++) {
                temp += arr[i]/mid;
            }

            if(temp < n) {
                end = mid-1;
            } else {
                start = mid+1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
