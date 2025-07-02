import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[] dice = {2,4,1,3,5,6};
    static int answer = 0;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int n, m;

    static void rollDice (int d) {
        int temp;
        if(d==0) {
            temp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[3];
            dice[3] = dice[2];
            dice[2] = temp;
        } else if(d==1) {
            temp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[4];
            dice[4] = dice[2];
            dice[2] = temp;
        } else if(d==2) {
            temp = dice[2];
            dice[2] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
        } else { // d==3
            temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[4];
            dice[4] = dice[5];
            dice[5] = temp;
        }
    }

    // (x, y)에서 동서남북 방향으로 연속해서 이동할 수 있는 칸의 수
    static int calc(int x, int y) {
        int num = map[x][y];
        int cnt = 1;
        boolean[][] v = new boolean[n][m];
        v[x][y] = true;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0;i<4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m && !v[nx][ny] && map[nx][ny]==num) {
                    cnt++;
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return cnt;
    }

    static void dfs(int x, int y, int dir, int cnt, int target) {
        if(cnt==target) {
            return;
        }

        int cx = x + dx[dir];
        int cy = y + dy[dir];
        if(cx<0 || cx>=n || cy<0 || cy>=m) {
            dir = (dir+2)%4;
            cx = x + dx[dir];
            cy = y + dy[dir];
        }

        answer += map[cx][cy]*calc(cx, cy);
        rollDice(dir);

        if(dice[5]>map[cx][cy]) {
            dir = (dir+1)%4;
        } else if (dice[5]<map[cx][cy]) {
            dir = (dir+3)%4;
        }

        dfs(cx,cy,dir,cnt+1,target);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int dir = 0;

        int k;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0,0,k);

        System.out.println(answer);
    }
}
