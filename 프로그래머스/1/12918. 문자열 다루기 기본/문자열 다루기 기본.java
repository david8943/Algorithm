class Solution {
    public boolean solution(String s) {
        boolean isPassed = true;
        
        if(s.length()!=4 && s.length()!=6) isPassed = false;
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)<'0' || s.charAt(i)>'9') {
                isPassed = false;
                break;
            }
        }
        
        return isPassed;
    }
}