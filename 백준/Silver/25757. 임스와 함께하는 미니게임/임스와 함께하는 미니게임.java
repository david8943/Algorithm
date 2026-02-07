import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int max = 0;
        if(game.equals("Y")) max = 1;
        else if(game.equals("F")) max = 2;
        else if(game.equals("O")) max = 3;

        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        System.out.println(set.size()/max);
    }
}
