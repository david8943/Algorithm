import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        int n = storage.length;
        int m = storage[0].length();
        
        answer = n*m;
        boolean[][] v = new boolean[n][m];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        
        for(String req : requests) {
            if(req.length()==2) { // 크레인
                char remove = req.charAt(0);
                for(int i=0;i<n;i++) {
                    for(int j=0;j<m;j++) {
                        if(storage[i].charAt(j)==remove && !v[i][j]) {
                            answer--;
                            v[i][j]=true;
                        } 
                    }
                }
            } else if(req.length()==1) { // 지게차
                char remove = req.charAt(0);
                boolean[][] tempV = new boolean[n][m]; // 해당 출고 요청으로 제거해야 되는 컨테이너들 임시 저장
                for(int i=0;i<n;i++) {
                    tempV[i] = v[i].clone();
                }
                
                for(int i=0;i<n;i++) {
                    for(int j=0;j<m;j++) {
                        if(storage[i].charAt(j)==remove && !v[i][j]) { // 존재하는 컨테이너
                            boolean isOpen = false;
                            
                            ArrayDeque<int[]> q = new ArrayDeque<>();
                            boolean[][] tempBfsV = new boolean[n][m]; // true 인 것들 방문 가능
                            // for(int l=0;l<n;l++) tempBfsV[l] = v[l].clone();
                            q.offer(new int[] {i,j});
                            
                            while(!q.isEmpty()) {
                                int[] xy = q.poll();
                                int cx = xy[0];
                                int cy = xy[1];
                                
                                if(cx==0 || cx==n-1 || cy==0 || cy==m-1) {
                                    isOpen = true;
                                    break;
                                }
                                    
                                for(int k=0;k<4;k++) {
                                    int nx = cx + dx[k];
                                    int ny = cy + dy[k];
                                    
                                    // tempBFSV가 false면 블럭 존재한다는 뜻
                                    if(nx<0 || nx>=n || ny<0 || ny>=m || tempBfsV[nx][ny] || !v[nx][ny]) continue;
                                    
                                    q.offer(new int[] {nx, ny});
                                    tempBfsV[nx][ny] = true;
                                }
                            }
                            
                            if(isOpen) {
                                answer--;
                                tempV[i][j]=true;
                            }
                        }
                    }
                }
                for(int i=0;i<n;i++) {
                    v[i] = tempV[i].clone();
                }
            }
        }
        
        // for(int i=0;i<n;i++) {
        //     for(int j=0;j<m;j++) {
        //         System.out.print(v[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        
        return answer;
    }
}