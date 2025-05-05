import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int r = land.length;
        int c = land[0].length;
        boolean[][] v = new boolean[r][c];
        int[] arr = new int[c];
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(land[i][j]==1 && !v[i][j]) {
                    ArrayDeque<int[]> deque = new ArrayDeque<>();
                    deque.offer(new int[] {i, j});
                    v[i][j] = true;
                    int tempOil = 1;
                    Set<Integer> set = new HashSet<>(); // 덩어리의 y 좌표 저장
                    set.add(j);
                
                    while(!deque.isEmpty()) {
                        int[] xy = deque.poll();
                        int cx = xy[0];
                        int cy = xy[1];
                    
                        for(int k=0;k<4;k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];
                        
                            if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
                            if(land[nx][ny]==1 && !v[nx][ny]) {
                                tempOil++;
                                v[nx][ny] = true;
                                deque.offer(new int[] {nx, ny});
                                set.add(ny);
                            }
                        }
                    }
                    // 덩어리 계산 끝,
                    for(int x : set) {
                        arr[x] += tempOil;
                    }
                }
            }
        }
        for(int i=0;i<c;i++) answer = Math.max(answer, arr[i]);
        
        return answer;
    }
}