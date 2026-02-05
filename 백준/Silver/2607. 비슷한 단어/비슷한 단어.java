import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 더하거나 빼면 둘 차이는 1 -
        // 바꾸면 둘 차이는 2 - 길이 같음
        // AB A
        // ABB AB
        // ABC ABD
        // ABC ABB

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String first = br.readLine();
        int[] alphabet = new int[26];
        for(int i = 0; i < first.length(); i++) {
            alphabet[first.charAt(i) - 'A']++;
        }

        int answer = 0;
        for(int i=1;i<N;i++) {
            String temp = br.readLine();
            int[] tempAlphabet = new int[26];
            for(int j = 0; j < temp.length(); j++) {
                tempAlphabet[temp.charAt(j) - 'A']++;
            }

            int diff = 0;
            for(int j=0;j<26;j++) {
                diff += Math.abs(alphabet[j] - tempAlphabet[j]);
            }
            if((diff==1 && Math.abs(first.length()-temp.length())==1) || ((diff==2 || diff==0) && first.length()==temp.length())) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
