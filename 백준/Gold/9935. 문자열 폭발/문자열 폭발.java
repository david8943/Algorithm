import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String bomb = br.readLine();

        Deque<Character> s = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();

        for(int i=0;i<input.length();i++) {
            s.offerLast(input.charAt(i));
            if(s.size()>=bomb.length()) {
                boolean isMatch = true;

                for(int j=0;j<bomb.length();j++) {
                    char c = s.pollLast();
                    temp.offerFirst(c);
                    if(c != bomb.charAt(bomb.length()-j-1)) {
                        isMatch = false;
                    }
                }
                if(!isMatch) {
                    for(int j=0;j<bomb.length();j++) {
                        s.offerLast(temp.pollFirst());
                    }
                }
                temp.clear();
            }
        }

        if(s.size()==0) {
            System.out.println("FRULA");
        } else {
            while(!s.isEmpty()) {
                sb.append(s.pollFirst());
            }
            System.out.println(sb.toString());
        }
    }
}
