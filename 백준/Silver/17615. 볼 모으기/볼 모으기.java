import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] balls = new int[N];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if(s.charAt(i) == 'R') {
                balls[i] = 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        int color = balls[0];
        int index = 0;
        list.add(0);

        for(int i = 0; i < N; i++) {
            if(balls[i] != color) {
                list.add(1);
                color = balls[i];
                index++;
            } else {
                list.set(index, list.get(index) + 1);
            }
        }

        if(list.size()%2 == 1) {
            int red = 0;
            for(int i=0;i<list.size();i+=2) {
                red += list.get(i);
            }
            red -= Math.max(list.get(0), list.get(list.size()-1));
            answer = Math.min(red, answer);

            int blue = 0;
            for(int i=1;i<list.size();i+=2) {
                blue += list.get(i);
            }
            answer = Math.min(blue, answer);
        } else {
            int red = 0;
            for(int i=0;i<list.size();i+=2) {
                red += list.get(i);
            }
            red -= list.get(0);
            answer = Math.min(red, answer);

            int blue = 0;
            for(int i=1;i<list.size()-1;i+=2) {
                blue += list.get(i);
            }
            answer = Math.min(blue, answer);
        }
        System.out.println(answer);
    }
}
