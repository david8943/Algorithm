import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int n = lock.length;
        int m = key.length;
        int empty = 0;
        
        // 자물쇠 확장하기
        int[][] map = new int[n+2*(m-1)][n+2*(m-1)];
        for(int i=0;i<n+2*(m-1);i++)
            Arrays.fill(map[i],-1);
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[m-1+i][m-1+j] = lock[i][j];
                if(lock[i][j]==0) empty++;
            }
        }
        
        int[][] nKey = new int[m][m];
        
        for(int t=0;t<4;t++) {
            // 키 회전
            for(int i=0;i<m;i++) {
                for(int j=0;j<m;j++) {
                    nKey[m-j-1][i] = key[i][j];
                }
            }
            for(int i=0;i<m;i++) {
                for(int j=0;j<m;j++) {
                    key[i][j] = nKey[i][j];
                }
            }
            
            for(int sx=0;sx<=m-1+n-1;sx++) {
                for(int sy=0;sy<=m-1+n-1;sy++) {
                    // 해당 점에서 키 넣기
                    int filled = 0;
                    boolean isCollision = false;
                    for(int i=0;i<m;i++) {
                        for(int j=0;j<m;j++) {
                            if(map[sx+i][sy+j]==0 && key[i][j]==1) {
                                filled++;
                            }
                            if(map[sx+i][sy+j]==1 && key[i][j]==1) {
                                isCollision = true;
                                break;
                            }
                        }
                        if(isCollision) break;
                    }

                    if(!isCollision) {
                        if(empty == filled) return true;
                    }
                }
            }
        }
        
        return answer;
    }
}