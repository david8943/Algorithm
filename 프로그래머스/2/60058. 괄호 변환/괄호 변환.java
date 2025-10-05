import java.util.*;

class Solution {
    static String first(String p) {
        if(p.length()==0) return p;
        
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        int left = 0;
        int right = 0;
        
        if(p.charAt(0)=='(') left++;
        if(p.charAt(0)==')') right++;
        u.append(p.charAt(0));
        
        int idx = 1;
        
        while(left!=right && idx<p.length()) {
            if(p.charAt(idx)=='(') left++;
            else right++;
            u.append(p.charAt(idx));
            idx++;
        }
        
        v.append(p.substring(idx));
        
        // u가 올바른 괄호 문자열인지 체크
        boolean isRight = true;
        
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for(int i=0;i<u.length();i++) {
            if(u.charAt(i)=='(') {
                deque.offer('(');
            } else {
                if(deque.isEmpty()) {
                    isRight = false;
                    break;
                }
                char c = deque.pollLast();
                if(c != '(') {
                    isRight = false;
                    break;
                }
            }
        }
        
        if(isRight) { // 문자열 v에 대해 1단계부터 다시 수행합니다. 
            String s = first(v.toString());
            return u.append(s).toString();
        } else {
            StringBuilder temp = new StringBuilder();
            temp.append('(');
            temp.append(first(v.toString()));
            temp.append(')');
            
            u.delete(0,1);
            u.delete(u.length()-1,u.length());
            for(int i=0;i<u.length();i++) {
                if(u.charAt(i)=='(') temp.append(')');
                else temp.append('(');
            }
            return temp.toString();
        }
    } 
    
    public String solution(String p) {
        String answer = first(p);
        
        return answer;
    }
}