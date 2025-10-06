import java.util.*;

class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    
    static int[] rdx1 = {-1,-1,0,0};
    static int[] rdy1 = {0,1,0,1};
    
    static int[] rdx2 = {0,0,1,1};
    static int[] rdy2 = {-1,0,-1,0};
    
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        
        boolean[][][] v = new boolean[n][n][2]; // 0은 가로, 1은 세로
        
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        v[0][0][0] = true;
        deque.offer(new int[] {0,0,0,0});
        
        while(!deque.isEmpty()) {
            int[] xydt = deque.poll();
            int x = xydt[0];
            int y = xydt[1];
            int d = xydt[2];
            int t = xydt[3];
            
            if((x==n-1 && y==n-2 && d==0) || (x==n-2 && y==n-1 && d==1)) {
                answer = t;
                break;
            }
            
            // 상하좌우 이동
            for(int i=0;i<4;i++) {
                if(d==0) {
                    int fx = x + dx[i];
                    int fy = y + dy[i];
                    int lx = x + dx[i];
                    int ly = y+1 + dy[i];
                    
                    if(fx>=0 && fx<n && fy>=0 && fy<n && lx>=0 && lx<n && ly>=0 && ly<n && board[fx][fy]==0 && board[lx][ly]==0 && !v[fx][fy][0]) {
                        v[fx][fy][0] = true;
                        deque.offer(new int[] {fx,fy,0,t+1});
                    }
                }
                
                if(d==1) {
                    int fx = x + dx[i];
                    int fy = y + dy[i];
                    int lx = x+1 + dx[i];
                    int ly = y + dy[i];
                    
                    if(fx>=0 && fx<n && fy>=0 && fy<n && lx>=0 && lx<n && ly>=0 && ly<n && board[fx][fy]==0 && board[lx][ly]==0 && !v[fx][fy][1]) {
                        v[fx][fy][1] = true;
                        deque.offer(new int[] {fx,fy,1,t+1});
                    }
                }
            }
            // 회전
            // static int[] rdx1 = {-1,-1,0,0};
            // static int[] rdy1 = {0,1,0,1};
            if(d==0) {
                for(int i=0;i<4;i++) {
                    int fx = x + rdx1[i];
                    int fy = y + rdy1[i];
                    int lx = x+1 + rdx1[i];
                    int ly = y + rdy1[i];
                    
                    if(fx>=0 && fx<n && fy>=0 && fy<n && lx>=0 && lx<n && ly>=0 && ly<n && board[fx][fy]==0 && board[lx][ly]==0 && !v[fx][fy][1]) {                  
                        if(i==0 && board[x-1][y+1]==1) continue;
                        if(i==1 && board[x-1][y]==1) continue;
                        if(i==2 && board[x+1][y+1]==1) continue;
                        if(i==3 && board[x+1][y]==1) continue;
                        v[fx][fy][1] = true;
                        deque.offer(new int[] {fx,fy,1,t+1});
                    }
                }
            } else {
                // static int[] rdx2 = {0,0,1,1};
                // static int[] rdy2 = {-1,0,-1,0};
                for(int i=0;i<4;i++) {
                    int fx = x + rdx2[i];
                    int fy = y + rdy2[i];
                    int lx = x + rdx2[i];
                    int ly = y+1 + rdy2[i];
                    
                    if(fx>=0 && fx<n && fy>=0 && fy<n && lx>=0 && lx<n && ly>=0 && ly<n && board[fx][fy]==0 && board[lx][ly]==0 && !v[fx][fy][0]) {
                        if(i==0 && board[x+1][y-1]==1) continue;
                        if(i==1 && board[x+1][y+1]==1) continue;
                        if(i==2 && board[x][y-1]==1) continue;
                        if(i==3 && board[x][y+1]==1) continue;
                        v[fx][fy][0] = true;
                        deque.offer(new int[] {fx,fy,0,t+1});
                    }
                }
            }
        }
        
        return answer;
    }
}