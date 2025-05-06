import java.util.*;

class Solution {
    static List<homework> list = new ArrayList<>();
    
    static class homework {
        String name;
        int hour;
        int min;
        int playtime;
        
        public homework(String name, int hour, int min, int playtime){
            this.name = name;
            this.hour = hour;
            this.min = min;
            this.playtime = playtime;
        }
        
        @Override
        public String toString() {
            return name + " " + playtime;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        for(int i=0;i<plans.length;i++) {
            String[] tempString = plans[i][1].split(":");
            int h = Integer.parseInt(tempString[0]);
            int m = Integer.parseInt(tempString[1]);
            int p = Integer.parseInt(plans[i][2]);
            
            list.add(new homework(plans[i][0], h, m, p));
        }
        
        list.sort((a,b)->{
            if(a.hour!=b.hour) return a.hour-b.hour;
            return a.min-b.min;
        });
        
        ArrayDeque<homework> queue = new ArrayDeque<>();
        int idx = 0;
        list.add(new homework("last", 10000, 0, 0));
        
        for(int i=0;i<list.size()-1;i++) {
            int gap = 60*(list.get(i+1).hour-list.get(i).hour) + list.get(i+1).min-list.get(i).min;
            
            if(gap>=list.get(i).playtime) {
                answer[idx++] = list.get(i).name;
                gap -= list.get(i).playtime;
                
                while(gap > 0 && queue.size() > 0) {
                    // System.out.println(list.get(i).name+" "+gap+" "+queue);
                    homework savedClass = queue.pollLast();
                    if(gap >= savedClass.playtime) {
                        gap -= savedClass.playtime;
                        answer[idx++] = savedClass.name;
                    }
                    else {
                        queue.offer(new homework(savedClass.name, 0, 0, savedClass.playtime-gap));
                        gap = 0;
                    }
                }
            } else {
                queue.offer(new homework(list.get(i).name, 0, 0, list.get(i).playtime-gap));
            }
        }
        
        return answer;
    }
}