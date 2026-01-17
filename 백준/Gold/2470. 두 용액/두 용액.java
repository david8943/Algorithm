import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0, end = n-1;
        int answer1 = 0, answer2 = 0;
        int result = Integer.MAX_VALUE;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (Math.abs(sum) < result) {
                result = Math.abs(sum);
                answer1 = start;
                answer2 = end;
            }

            if(sum>0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(arr[answer1] + " " + arr[answer2]);
    }
}
