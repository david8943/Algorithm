class Solution {
    static int[] arr;
    static int[] resArr = new int[5];
    static int answer = 0;
    
    static void Comb(int cnt, int start, int n, int[][]q, int[] ans) {
        if(cnt==5) {
            check(q, ans);
            return;
        }
        
        for(int i=start;i<n;i++){
            resArr[cnt] = arr[i];
            Comb(cnt+1,i+1,n,q,ans);
        }
    }
    
    static void check(int[][]q, int[] ans) {
        int m = q.length;

        for(int t=0;t<m;t++) { // t번째 배열과 resArr가 겹치는 숫자 개수 == ans[t] 인가?
            int sameNumber = 0; // 포함된 정수의 개수
            for(int i=0;i<5;i++) {
                for(int j=0;j<5;j++) {
                   if(q[t][i]==resArr[j]) sameNumber++;
                }
            }
            if(sameNumber != ans[t]) return;
        }
        answer++;
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=i+1;
        }
        
        Comb(0,0,n,q,ans);
        return answer;
    }
}