import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void normalBfs(int x, int y) {
        char c = map[x][y];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x,y});
        v[x][y] = true;

        while(!q.isEmpty()) {
            int[] xy = q.poll();
            int cx = xy[0];
            int cy = xy[1];

            for(int i=0;i<4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny]!=c || v[nx][ny]) {
                    continue;
                }
                v[nx][ny]=true;
                q.offer(new int[] {nx,ny});
            }
        }
    }

    static void rgBfs(int x, int y) {
        char c = map[x][y];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x,y});
        v[x][y] = true;

        while(!q.isEmpty()) {
            int[] xy = q.poll();
            int cx = xy[0];
            int cy = xy[1];

            for(int i=0;i<4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny]!=c || v[nx][ny]) {
                    continue;
                }
                v[nx][ny]=true;
                q.offer(new int[] {nx,ny});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int normalArea = 0;
        int rgArea = 0;

        map = new char[N][N];

        for(int i=0;i<N;i++) {
            String temp = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        v = new boolean[N][N];
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    normalArea++;
                    normalBfs(i,j);
                }
            }
        }

        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        v = new boolean[N][N];
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) {
                    rgArea++;
                    rgBfs(i,j);
                }
            }
        }

        System.out.println(normalArea+" "+rgArea);
    }
}
