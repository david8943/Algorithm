import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] map;
    static ArrayDeque<Tomato> deque = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int result;

    static class Tomato {
        int x;
        int y;
        int z;
        int day;

        Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    static void bfs() {
        while(!deque.isEmpty()) {
            Tomato tomato = deque.poll();
            int x = tomato.x;
            int y = tomato.y;
            int z = tomato.z;
            int day = tomato.day;
            result = day;

            for(int i=0;i<6;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                int nday = day + 1;

                if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H || map[nz][nx][ny]!=0) continue;

                map[nz][nx][ny] = 1;
                deque.offer(new Tomato(nx, ny, nz, nday));
            }
        }
    }

    static boolean isRipen() {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][i][j] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if (map[k][i][j] == 1) {
                        deque.offer(new Tomato(i, j, k,0));
                    }
                }
            }
        }

        bfs();
        if(isRipen()) System.out.println(result);
        else System.out.println(-1);
    }
}