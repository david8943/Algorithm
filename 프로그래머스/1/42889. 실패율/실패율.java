import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] answerArr = new double[N][2];
        int[] challenged = new int[N+2];
        int[] stopped = new int[N+2];
        int[] answer = new int[N];
        
        for(int i:stages) {
            for(int j=1;j<=i;j++) {
                challenged[j]++;
            }
            stopped[i]++;
        }
        
        for(int i=0;i<N;i++) {
            answerArr[i][1] = i+1;
        }
        
        for(int i=0;i<N;i++) {
            if(challenged[i+1]==0) answerArr[i][0] = 0;
            else {
                answerArr[i][0] = (double)stopped[i+1]/challenged[i+1];   
            }
        }
        
        // Arrays.sort(answerArr,(a,b)->b[0]-a[0]);
        Arrays.sort(answerArr, (a, b) -> {
            int compare = Double.compare(b[0], a[0]);  // 실패율 내림차순
            if(compare == 0) {
                return Double.compare(a[1], b[1]);  // 같으면 스테이지 오름차순
            }
            return compare;
        });
        
        for(int i=0;i<N;i++) {
            answer[i] = (int)answerArr[i][1];
        }
        
        return answer;
    }
}