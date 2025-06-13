import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int n;
    static boolean[] v;
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        list = new ArrayList[n+1];
        v = new boolean[n+1];

        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for( int i=2;i<=n;i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int idx) {
        v[idx] = true;
        for(int i:list[idx]) {
            if(!v[i]) {
                parent[i] = idx;
                dfs(i);
            }
        }
    }
}
