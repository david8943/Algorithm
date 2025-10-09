import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static int N, R, C;
    static char[] menu; // 2번 이상 주문된 메뉴들
    static char[] b;
    static String[] orderList;
    static List<Set<Character>> orderSets;

    static void comb(int cnt, int start) {
        if(cnt == R) { // b가 특정 order에 포함되어 있으면 map에 추가하기
            Set<Character> combSet = new HashSet<>();
            for(int i = 0; i < R; i++) {
                combSet.add(b[i]);
            }
            int containCount = 0;
                

            for(Set<Character> orderSet : orderSets) {
                if(orderSet.containsAll(combSet)) {
                    containCount++;
                }
            }
            
            if(containCount>=2) {
                String key = new String(b);
                map.put(key, containCount);
            }
            
            return;
        }
        
        for(int i=start;i<menu.length;i++) {
            b[cnt] = menu[i];
            comb(cnt+1, i+1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> answerList = new ArrayList<>();
        orderList = orders;
        
        orderSets = new ArrayList<>();
        for(String temp: orders) {
            Set<Character> tempSet = new HashSet<>();
            for(char c: temp.toCharArray()) {
                tempSet.add(c);
            }
            orderSets.add(tempSet);
        }
        
        // 2개 이상 주문된 메뉴 저장
        int[] tempMenu = new int[26];
        int menuCount = 0;
        for(String s : orders) {
            for(int i=0;i<s.length();i++) {
                tempMenu[s.charAt(i)-'A'] += 1;
                if(tempMenu[s.charAt(i)-'A'] == 2) menuCount++;
            }
        }
        
        menu = new char[menuCount];
        int idx = 0;
        for(int i=0;i<26;i++) {
            if(tempMenu[i]>1) {
                menu[idx++] = (char)(i + 'A');
            }
        }
        N = menuCount;
        
        // 코스 메뉴 숫자에 따라 구하기
        for(int courseNumber : course) {
            map = new LinkedHashMap<>();
            b = new char[courseNumber];
            R = courseNumber; // 이거 빼먹음
            comb(0,0);
            
            // 가장 많이 함께 주문한 단품메뉴들 구해야
            int max = 0;
            
            for(String key : map.keySet()) {
                int value = map.get(key);
                if(value>max) {
                    max = value;
                }
            }
            
            if(max>=2) {
                for(String key : map.keySet()) {
                    int value = map.get(key);
                    if(value == max) {
                        answerList.add(key);
                    }
                }
            }
        }
        
        Collections.sort(answerList);
        answer = new String[answerList.size()];
        
        for(int i=0;i<answer.length;i++) {
            answer[i] = answerList.get(i); 
        }
        
        return answer;
    }
}