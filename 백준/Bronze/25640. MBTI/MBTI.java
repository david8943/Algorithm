import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        String jinho = br.readLine();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            if(temp.equals(jinho)) result++;
        }
        System.out.println(result);
    }
}
