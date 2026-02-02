import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.parseInt(st.nextToken());;
        int before = 0;
        int now = 0;

        for(int i=1;i<M;i++) {
            now = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, (now-before+1)/2);
            before = now;
        }

        answer = Math.max(answer, N-before);
        System.out.println(answer);
    }
}
