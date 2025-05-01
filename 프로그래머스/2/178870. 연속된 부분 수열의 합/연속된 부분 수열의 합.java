class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0, end = 0;
        int sum = sequence[start];
        int al = Integer.MAX_VALUE;
        int sl = sequence.length;
        
        while(end<sl) {
            if(sum<k) {
                end++;
                if(end<sl) sum += sequence[end];
            } else {
                if(sum==k) {
                    int tl = end-start+1;
                    if(tl<al) {
                        answer[0] = start;
                        answer[1] = end;
                        al = tl;
                    }
                }
                sum -= sequence[start];
                start++;
            }
        }
        
        return answer;
    }
}