import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++) {
            String temp = br.readLine();
            sb.append(i).append(". ").append(temp).append("\n");
        }
        System.out.print(sb);
    }
}