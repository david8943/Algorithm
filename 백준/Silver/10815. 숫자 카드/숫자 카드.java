import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int aim = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = arr.length-1;

            while(true){
                if(start>end) {
                    sb.append("0 ");
                    break;
                }

                int mid = (start+end)/2;
                if(arr[mid]<aim){
                    start = mid+1;
                } else if(arr[mid]>aim){
                    end = mid-1;
                } else {
                    sb.append("1 ");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
