import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n+1];
        ArrayList<Integer> list[] = new ArrayList[n+1];
        boolean[] v = new boolean[n+1];

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

        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[1] = true;
        q.offer(1);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : list[cur]) {
                if(!v[next]) {
                    v[next] = true;
                    parent[next] = cur;
                    q.offer(next);
                }
            }
        }

        for( int i=2;i<=n;i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}
