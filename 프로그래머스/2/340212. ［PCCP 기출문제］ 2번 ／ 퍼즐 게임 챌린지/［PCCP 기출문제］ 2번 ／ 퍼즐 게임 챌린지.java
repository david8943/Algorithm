class Solution {
    static long calc(int[] diffs, int[] times, int level) {
        long timeSum = 0;
        int time_prev = 0;
        
        for(int i=0;i<diffs.length;i++) {
            int time_cur = times[i];
            if(diffs[i] <= level) timeSum += time_cur;
            else timeSum += (diffs[i]-level)*(time_prev+time_cur) + time_cur;
            time_prev = time_cur;
        }
        return timeSum;
    }
        
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int start = 1;
        int end = 100000;
        int mid = 1;
        
        while(true) {
            if(start>end) break;
            
            mid = (start+end)/2;
            long estimatedTime = calc(diffs, times, mid);
            
            if(estimatedTime <= limit) {
                end = mid-1;
                answer = mid;
            }
            else start = mid+1;
        }
        return answer;
    }
}