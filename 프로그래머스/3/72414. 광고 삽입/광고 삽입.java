class Solution {
    static int convert(String s) {
        String[] temp = s.split(":");
        return Integer.parseInt(temp[0])*3600+Integer.parseInt(temp[1])*60+Integer.parseInt(temp[2]);
    }
    
    static String convertS(int n) {
        int h = n/3600;
        int m = (n%3600)/60;
        int s = n%60;
        
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int play_time_sec = convert(play_time);
        int adv_time_sec = convert(adv_time);
        int[] viewers = new int[play_time_sec+1];
        
        for(int i=0;i<logs.length;i++) {
            String[] temp = logs[i].split("-");
            int start = convert(temp[0]);
            int end = convert(temp[1]);
            
            viewers[start]+=1;
            viewers[end]-=1;
        }
        
        for(int i=1;i<=play_time_sec;i++) {
            viewers[i] += viewers[i-1];
        }
        
        long[] prefix = new long[play_time_sec + 1];
        for(int i=1; i<=play_time_sec; i++) {
            prefix[i] = prefix[i-1] + viewers[i-1];
        }
        
        long answerSec = 0;
        int answerTime = 0;
        
        for(int i=0;i<=play_time_sec-adv_time_sec;i++) {
            long temp = prefix[i+adv_time_sec]-prefix[i];
            if(temp>answerSec) {
                answerSec = temp;
                answerTime = i;
            }
        }
        
        return convertS(answerTime);
    }
}