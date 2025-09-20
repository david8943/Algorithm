import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays. sort(arr, (a,b)->Integer.compare(a[0],b[0]));

        int answer = 0;
        int covered = 0;
        for(int i=0;i<n;i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if(covered>=end) continue;

            int needStart = Math.max(covered, start);
            int needLength = end - needStart;

            int boardCount = (needLength+l-1)/l;
            answer += boardCount;

            covered = needStart + boardCount*l;
        }
        System.out.println(answer);
    }
}
