import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int n = targets.length;
        
        Arrays.sort(targets, (o1, o2) -> {
            return o1[0]-o2[0];
        });
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        
        // Queue<Integer> pq = new PriorityQueue<>();
        int last = -1;
        
        for(int i=0;i<n;i++) {
            if(targets[i][0] < last) continue;
            last = targets[i][1];
            answer++;
        }
        
        return answer;
    }
}