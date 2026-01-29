import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        int x=0, y=0;

        for(int i=0;i<N;i++) {
            String temp = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        for(int i=1;i<N-1;i++) {
            for(int j=1;j<N-1;j++) {
                if(map[i][j] == '*') {
                    if(map[i-1][j] == '*' && map[i][j-1] == '*') {
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
        }

        int la=0, ra=0, ll=0, rl=0, w=0;

        for(int i=1;i<N;i++) {
            if(y-i >= 0 && map[x][y-i] == '*') {
                la++;
            } else {
                break;
            }
        }
        for(int i=1;i<N;i++) {
            if(y+i < N && map[x][y+i] == '*') {
                ra++;
            } else {
                break;
            }
        }
        for(int i=1;i<N;i++) {
            if(x+i < N && map[x+i][y] == '*') {
                w++;
            } else {
                break;
            }
        }
        for(int i=1;i<N;i++) {
            if(x+w+i < N && map[x+w+i][y-1] == '*') {
                ll++;
            } else {
                break;
            }
        }
        for(int i=1;i<N;i++) {
            if(x+w+i < N && map[x+w+i][y+1] == '*') {
                rl++;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        x++;
        y++;
        sb.append(x+" "+y).append("\n");
        sb.append(la+" "+ra+" "+w+" "+ll+" "+rl);

        System.out.println(sb.toString());
    }
}
