class Solution {
    public int solution(String s) {
        int answer = s.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder tempAnswer = new StringBuilder();
        
        for(int l=1;l<=s.length()/2;l++) {
            tempAnswer.setLength(0);
            
            // 앞에서부터 l개 반복되는지 확인
            String before = s.substring(0,l);
            String now = s.substring(0,l);
            
            int r = 1;
            for(int i=l;i<=s.length()-l;i+=l) {
                now = s.substring(i,i+l);
                
                if(before.equals(now)) {
                    r++;
                } else {
                    if(r>=2) {
                        tempAnswer.append(r).append(before);
                    } else {
                        tempAnswer.append(before);
                    }
                    r = 1;
                    before = now;
                }
                
            }
            
            if(r>=2) {
                tempAnswer.append(r).append(now);
            } else {
                tempAnswer.append(now);
            }
            // 남은 부분 붙여주기 - 길이 s%l
            String etc = s.substring(s.length()-s.length()%l,s.length());
            tempAnswer.append(etc);
            
            if(tempAnswer.length()<answer) {
                answer = tempAnswer.length();
                sb = new StringBuilder(tempAnswer.toString());
            }
        }
        
        System.out.println(sb);
        
        return answer;
    }
}