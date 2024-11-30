import java.io.*;
import java.util.*;

public class Main {

    static int factorial(int n){
        if(n == 0){
            return 1;
        } else if(n == 1){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        System.out.println(factorial(n) / (factorial(n-r) * factorial(r)));
    }
}