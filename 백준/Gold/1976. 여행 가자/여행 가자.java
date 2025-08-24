import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX > rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) {
                int inputNum = Integer.parseInt(st.nextToken());
                if(inputNum == 1) {
                    if(find(i) != find(j)) {
                        union(i, j);
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        boolean isPossible = true;
        for(int i=1;i<m;i++) {
             int next = Integer.parseInt(st.nextToken());
             if(find(next) != find(start)) {
                 isPossible = false;
                 break;
             }
        }

        if(isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
