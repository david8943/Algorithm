import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int aim;
    static int cur;
    static ArrayDeque<int[]> deque = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int result = -1;

    static void dfs(int day, int ripen) {
        if(ripen == aim) {
            result = day;
            return;
        }

        boolean isRipen = false;
        ArrayDeque<int[]> temp = new ArrayDeque<>();

        while(!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cx = cur[0], cy = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    ripen++;
                    isRipen = true;
                    temp.offer(new int[]{nx, ny});
                }
            }
        }

        if(!isRipen) {
            return;
        }

        deque = temp;
        dfs(day+1, ripen);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++) {
            st  = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) aim++; // 획득해야 되는 토마토 수
                if(map[i][j] == 1) deque.offer(new int[]{i,j});
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }
}
