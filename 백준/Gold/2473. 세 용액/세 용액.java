import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;

        int first = -1;
        int second = -1;
        int third = -1;

        for (int i = 0; i < N-2; i++) {
            int left = i+1;
            int right = N-1;

            while(left < right) {
                long sum = (long)arr[i] + arr[left] + arr[right];

                if(Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    first = i;
                    second = left;
                    third = right;
                }
                if(sum == 0) {
                    first = i;
                    second = left;
                    third = right;
                    break;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(arr[first]+" "+arr[second]+" "+arr[third]);
    }
}
