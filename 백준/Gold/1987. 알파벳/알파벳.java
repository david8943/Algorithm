import java.io.*;
import java.util.*;

public class Main {
    static int r,c;
    static char[][] map;
    static boolean[] alpha = new boolean[26];
    static int result = 1;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y, int depth) {
        result = Math.max(result, depth);

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx>=0 && nx<r && ny>=0 && ny<c) {
                char nextChar = map[nx][ny];
                if(!alpha[nextChar-'A']) {
                    alpha[nextChar-'A'] = true;
                    dfs(nx, ny, depth+1);
                    alpha[nextChar-'A'] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for(int i = 0; i < r; i++) {
            String temp = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        alpha[map[0][0]-'A'] = true;
        dfs(0, 0, 1);
        System.out.println(result);
    }
}
