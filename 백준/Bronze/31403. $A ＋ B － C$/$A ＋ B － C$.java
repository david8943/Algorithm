import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());

        System.out.println(n1+n2-n3);

        // n2의 길이 구하기
        int len = (int)String.valueOf(n2).length();
        System.out.println(n1*(int)Math.pow(10,len)+n2-n3);
    }
}