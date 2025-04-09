import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] v;
    static int n, m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int result = 0;

    static void dfs(int sx, int sy, int cnt, int sum) {
        if(cnt==4) {
            result = Math.max(result, sum);
            return;
        }

        for(int k=0;k<4;k++){
            int nx = sx + dx[k];
            int ny = sy + dy[k];
            if(nx>=1 && nx<=n && ny>=1 && ny<=m && !v[nx][ny]){
                v[nx][ny] = true;
                dfs(nx,ny,cnt+1,sum+map[nx][ny]);
                v[nx][ny] = false;
            }
        }
    }

    static void searchT(int x, int y) { // ㅗ 모양
        int tempSum = map[x][y];
        for(int k=0;k<4;k++){
            tempSum += map[x+dx[k]][y+dy[k]];
        }
        for(int k=0;k<4;k++){
            result = Math.max(result, tempSum-map[x+dx[k]][y+dy[k]]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+2][m+2];
        v = new boolean[n+2][m+2];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                v[i][j] = true;
                dfs(i,j,1,map[i][j]);
                v[i][j] = false;
                searchT(i,j);
            }
        }

        System.out.println(result);
    }
}
