import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {
                    result[i][j] += a[i][k]*b[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }

    static int[][] power(int[][] A, long B) {
        if(B==1) {
            int[][] identity = new int[N][N];
            for(int i=0;i<N;i++) {
                identity[i][i] = 1;
            }
            return multiply(A, identity);
        }

        int[][] half = power(A, B/2);
        int[][] result = multiply(half, half);

        if(B % 2 == 1) {
            result = multiply(result, A);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] arr = new int[N][N];

        for(int i = 0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[N][N];
        result = power(arr, B);

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
