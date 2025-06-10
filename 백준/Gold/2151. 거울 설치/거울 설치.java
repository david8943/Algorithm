import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int dir;
        int cnt;

        public Node(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int sx, sy, ex, ey;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);

                if(map[i][j] == '#') {
                    if(idx==0) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                    idx++;
                }
            }
        }
        bfs();
    }

    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][][] v = new boolean[N][N][4];

        for(int i = 0; i < 4; i++) {
            pq.add(new Node(sx,sy,i,0));
        }

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cnt = cur.cnt;

            v[x][y][dir] = true;

            if(x==ex && y==ey) {
                System.out.println(cnt);
                return;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx>=0 && nx<N && ny>=0 && ny<N && !v[nx][ny][dir] && map[nx][ny] != '*') {
                if(map[nx][ny] == '!') {
                    int nDir = (dir+3)%4;
                    pq.add(new Node(nx,ny,nDir,cnt+1));

                    nDir = (dir+1)%4;
                    pq.add(new Node(nx,ny,nDir,cnt+1));
                }
                pq.add(new Node(nx,ny,dir,cnt));
            }
        }
    }
}
