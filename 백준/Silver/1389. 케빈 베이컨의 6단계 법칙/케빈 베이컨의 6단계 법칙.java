import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y]=1;
            arr[y][x]=1;
        }

         for(int k=1; k<=n; k++) {
             for(int i=1; i<=n; i++) {
                 for(int j=1; j<=n; j++) {
                    if(arr[i][j] > arr[i][k]+arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        arr[j][i] = arr[i][j];
                    }
                 }
             }
         }

//         for(int i=1; i<=n; i++) {
//             for(int j=1; j<=n; j++) {
//                 System.out.print(arr[i][j]+" ");
//             }
//             System.out.println();
//         }

         int ansN = 0;
         int ansV = Integer.MAX_VALUE;

         for(int i=1; i<=n; i++) {
             int tempSum = 0;
             for(int j=1; j<=n; j++) {
                 tempSum += arr[i][j];
             }
             if(tempSum < ansV) {
                 ansN = i;
                 ansV = tempSum;
             }
         }

        System.out.println(ansN);
    }
}
