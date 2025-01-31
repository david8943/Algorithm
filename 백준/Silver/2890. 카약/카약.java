import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[r];
        int[] result = new int[10]; // 1~9

        for(int i=0;i<r;i++) {
            String temp = br.readLine();
            for(int j=c-2;j>=1;j--) {
                if(temp.charAt(j)!='.') {
//                    System.out.println((int)temp.charAt(j));
                    arr[temp.charAt(j)-'0'] = j;
                    break;
                }
            }
        }

        for(int i=0;i<r;i++) {
            boolean[] v = new boolean[c];
            for(int j=0;j<r;j++) {
                if(arr[j]>arr[i]) {
                    v[arr[j]] = true;
                }
            }
            int temp = 0;
            for(int j=0;j<c;j++) {
                if(v[j]) {
                    temp++;
                }
            }
            if(arr[i]!=0) sb.append(temp+1).append("\n");
        }
        System.out.println(sb);
    }
}
