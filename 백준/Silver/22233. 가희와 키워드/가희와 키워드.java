import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> memo = new HashSet<>();
        for(int i=0;i<N;i++) {
            memo.add(br.readLine());
        }

        int size = memo.size();

        for(int i=0;i<M;i++) {
            String input = br.readLine();
            String[] arr = input.split(",");

            for(String a : arr) {
                if(memo.contains(a)) {
                    memo.remove(a);
                    size--;
                }
            }
            sb.append(size).append("\n");
        }
        System.out.println(sb);
    }
}
