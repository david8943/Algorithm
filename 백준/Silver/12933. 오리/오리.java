import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] quack = new char[] {'q','u','a','c','k'};

        if (s.length() % 5 != 0 || s.charAt(0) != 'q') { // 길이가 5의 배수가 아니거나 q로 시작하지 않으면
            System.out.println(-1); // 올바르지 않은 문자열
            return;
        }
        
        int answer = 0;

        boolean[] check = new boolean[s.length()];

        for(int i = 0; i < s.length(); i++) {
            int k = 0;
            boolean found = false;
            for(int j = 0; j < s.length(); j++) {
                if (!check[j] && s.charAt(j) == quack[k]) {
                    k++;
                    if(k==5) {
                        k=0;
                        found = true;
                    }
                    check[j] = true;
                }
            }
            if(k!=0) {
                answer = -1;
                break;
            }
            if(found) answer++;
        }

        System.out.println(answer);
    }
}
