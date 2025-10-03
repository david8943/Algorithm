class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<new_id.length();i++) {
            char temp = new_id.charAt(i);
            if((temp>='a' && temp<='z') || (temp>='0' && temp<='9') || temp=='-' || temp=='_' || temp=='.') {
                sb2.append(temp);
            }
        }
        
        // 3단계
        StringBuilder sb3 = new StringBuilder();
        for(int i=0;i<sb2.length();i++) {
            if(sb2.charAt(i)=='.') {
                while(i+1<sb2.length() && sb2.charAt(i+1)=='.') {
                    i++;
                }
                sb3.append('.');
            } else {
                sb3.append(sb2.charAt(i));
            }
        }
        
        // 4단계
        if(sb3.length()>0 && sb3.charAt(0)=='.') {
            sb3.deleteCharAt(0);
        }
        if(sb3.length()>0 && sb3.charAt(sb3.length()-1)=='.') {
            sb3.deleteCharAt(sb3.length()-1);
        }
        
        // 5단계
        if(sb3.length()==0) {
            sb3.append('a');
        }
        
        // 6단계
        if(sb3.length()>=16) {
            sb3.delete(15, sb3.length());
            if(sb3.charAt(14) == '.') sb3.deleteCharAt(14);
        }
        
        // 7단계
        if(sb3.length()==1) {
            sb3.append(sb3.charAt(0));
            sb3.append(sb3.charAt(0));
        } else if(sb3.length()==2) {
            sb3.append(sb3.charAt(1));
        }
        
        answer = sb3.toString();
        
        return answer;
    }
}