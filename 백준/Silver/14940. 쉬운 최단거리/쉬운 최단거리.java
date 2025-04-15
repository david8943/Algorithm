import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] v;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void bfs(int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 0});
        v[x][y] = true;
        map[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], d = cur[2];

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k], ny = cy + dy[k];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny]!=1 || v[nx][ny]) continue;
                map[nx][ny] = d+1;
                q.add(new int[]{nx, ny, map[nx][ny]});
                v[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        v = new boolean[n][m];
        int x = -1, y = -1;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!v[i][j]) {
                    if(map[i][j]==0) sb.append(0 +" ");
                    else if(map[i][j]==1) sb.append(-1+" ");
                }
                else sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
