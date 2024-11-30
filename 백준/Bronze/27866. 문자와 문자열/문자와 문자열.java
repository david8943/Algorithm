import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        n = Integer.parseInt(br.readLine());

        System.out.println(s.charAt(n-1));
    }
}