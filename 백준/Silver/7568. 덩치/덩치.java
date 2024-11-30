import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for(int j = 0; j < n; j++){
                if(arr[j][0]>arr[i][0] && arr[j][1]>arr[i][1]){
                    temp++;
                }
            }
            res[i] = temp+1;
        }

        for(int i = 0; i < n; i++){
            System.out.print(Integer.toString(res[i])+' ');
        }
    }
}