class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        
        for(int i=0;i<24;i++) {
            int plus = players[i]/m-servers[i];
            if(plus>0) {
                answer += plus;
                for(int j=0;j<k;j++) {
                    if(i+j<24) servers[i+j] += plus;
                }
            }
        }
        
        return answer;
    }
}