import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        int[] answer = new int[query.length];
        
        for(String s : info) {
            String[] parts = s.split(" ");
            String[] tempLanguage = {"-", parts[0]};
            String[] tempPosition = {"-", parts[1]};
            String[] tempExperience = {"-", parts[2]};
            String[] tempSoulfood = {"-", parts[3]};
            int score = Integer.parseInt(parts[4]);
            
            for(int i=0;i<2;i++) {
                for(int j=0;j<2;j++) {
                    for(int k=0;k<2;k++) {
                        for(int l=0;l<2;l++) {
                            String temp = tempLanguage[i]+tempPosition[j]+tempExperience[k]+tempSoulfood[l];
                            if(!map.containsKey(temp)) {
                                map.put(temp, new ArrayList<>());
                            }
                            map.get(temp).add(score);
                        }
                    }
                }
            }
        }
        
        for(ArrayList<Integer> t: map.values()) {
            Collections.sort(t);
        }
        
        int idx = 0;
        for(String s: query) {
            String[] parts = s.replace(" and "," ").split(" ");
            String key = parts[0]+parts[1]+parts[2]+parts[3];
            int targetScore = Integer.parseInt(parts[4]);
            
            if(map.containsKey(key)) {
                ArrayList<Integer> scoreList = map.get(key); 
                answer[idx] = scoreList.size() - findRank(scoreList, targetScore);
            } else {
                answer[idx] = 0;
            }
            idx++;
        }
        
        return answer;
    }
    
    static int findRank(ArrayList<Integer> list, int target) {
        int start = 0;
        int end = list.size()-1;
        int result = list.size();
        
        while(start<=end) {
            int mid = (start+end)/2;
            if(list.get(mid)>=target) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    } 
}