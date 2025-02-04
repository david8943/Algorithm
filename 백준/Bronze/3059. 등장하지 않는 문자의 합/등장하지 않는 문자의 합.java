import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int result = 0;
            String temp = br.readLine();
            boolean[] arr = new boolean[26];
            for(int j=0;j<temp.length();j++){
                int num = temp.charAt(j) - 'A';
                arr[num] = true;
            }
            for(int j=0;j<26;j++){
                if(!arr[j]){
                    result+=(int)'A'+j;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
