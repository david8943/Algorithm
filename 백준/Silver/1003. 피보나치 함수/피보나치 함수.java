import java.util.*;
import java.io.*;

public class Main {
    static int[][] array = new int[41][2];

    static void fibonacci(int n) {
        if(array[n][0] == 0 && array[n][1] == 0) { //계산된적 없음
            array[n][0] = array[n - 2][0] + array[n - 1][0];
            array[n][1] = array[n - 2][1] + array[n - 1][1];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        array[0][0] = 1;
        array[0][1] = 0;
        array[1][0] = 0;
        array[1][1] = 1;

        for(int i=2;i<=40;i++) {
            fibonacci(i);
        }

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
//            fibonacci(n);
            sb.append(array[n][0]).append(" ").append(array[n][1]).append("\n");
        }
        System.out.println(sb);
    }
}
