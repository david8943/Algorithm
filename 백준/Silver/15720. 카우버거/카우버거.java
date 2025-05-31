import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int b,c,d;
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int n = Math.min(b,Math.min(c,d));

        int[] arr1 = new int[b];
        int[] arr2 = new int[c];
        int[] arr3 = new int[d];

        int sum1 = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
            sum1 += arr1[i];
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
            sum1 += arr2[i];
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < d; i++) {
            arr3[i] = Integer.parseInt(st.nextToken());
            sum1 += arr3[i];
        }

        int sum2 = sum1;

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        for(int i = 0; i < n; i++) {
            sum2 -= arr1[b-i-1]*0.1;
            sum2 -= arr2[c-i-1]*0.1;
            sum2 -= arr3[d-i-1]*0.1;
        }

        System.out.println(sum1);
        System.out.println(sum2);
    }
}
