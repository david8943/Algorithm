import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x, y, cost;
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = 1;

        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n==0) break;
            map = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cost = bfs();
            sb.append("Problem "+t+": "+cost).append("\n");
            t++;
        }
        System.out.println(sb.toString());
    }

    static int bfs() {
        Queue<Node> q = new PriorityQueue<>();
        int[][] move = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }

        q.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];

        while(!q.isEmpty()) {
            Node pos = q.poll();
            int px = pos.x, py = pos.y;
            int cost = pos.cost;

            if(px == n-1 && py == n-1) {
                return cost;
            }

            for(int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;

                if(cost+map[nx][ny] < move[nx][ny]) {
                    move[nx][ny] = cost+map[nx][ny];
                    q.add(new Node(nx, ny, cost + map[nx][ny]));
                }
            }
        }
        return -1;
    }
}
