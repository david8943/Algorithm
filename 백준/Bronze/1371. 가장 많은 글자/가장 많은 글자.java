import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        String input;
        String str = "";

        int[] arr = new int[26];

        while((input = br.readLine()) != null) {
            str += input;
        }

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != ' ') {
                arr[str.charAt(i)-'a']++;

                if(arr[str.charAt(i)-'a'] > max) {
                    max = arr[str.charAt(i)-'a'];
                }
            }
        }

        for(int i=0;i<26;i++){
            if(max==arr[i]) {
                System.out.print((char) (i+'a'));
            }
        }
    }
}
