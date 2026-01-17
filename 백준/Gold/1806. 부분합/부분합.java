import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;

        while(right < n) {
            sum += arr[right++];

            while(sum >= s) {
                result = Math.min(result, right - left);
                sum -= arr[left++];
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
