import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[2000001];

        // -1000000 이면 0

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            arr[temp+1000000]++;
        }

        for(int i = 0; i < 2000001; i++){
            if(arr[i] > 0){
                for(int j=0;j<arr[i];j++) {
                    sb.append(i-1000000).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
