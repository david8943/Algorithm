import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static char[][] map;
    static ArrayDeque<int[]> w = new ArrayDeque<>();
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void flood() {
        ArrayDeque<int[]> temp = new ArrayDeque<>();
        while(!w.isEmpty()) {
            int[] xy = w.poll();
            int x = xy[0];
            int y = xy[1];

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny]=='.') {
                    map[nx][ny] = '*';
                    temp.add(new int[]{nx, ny});
                }
            }
        }
        w = temp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        v = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '*') {
                    w.offer(new int[]{i, j});
                }
                if(map[i][j] == 'S') {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int time = 0;

        while(!q.isEmpty()) {
            flood();

            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] xy = q.poll();
                int x = xy[0];
                int y = xy[1];

                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                    if(v[nx][ny]) continue;
                    if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;

                    if(map[nx][ny] == 'D') {
                        System.out.println(time+1);
                        return;
                    }

                    q.offer(new int[]{nx, ny});
                    v[nx][ny] = true;
                }
            }
            time++;
        }
        System.out.println("KAKTUS");
    }
}
