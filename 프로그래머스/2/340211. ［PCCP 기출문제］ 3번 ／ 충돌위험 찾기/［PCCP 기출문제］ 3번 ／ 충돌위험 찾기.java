import java.util.*;

class Solution {
    // path에 좌표들 추가
    static void addMovePath(List<int[]> path, int[] start, int[] end) {
        int startR = start[0];
        int startC = start[1];
        int endR = end[0];
        int endC = end[1];
        
        while(startR != endR) {
            if(endR > startR) {
                startR++;
            } else {
                startR--;
            }
            path.add(new int[]{startR, startC});
        }
        
        while(startC != endC) {
            if(endC > startC) {
                startC++;
            } else {
                startC--;
            }
            path.add(new int[]{startR, startC});
        }
    }
    
    // 포인트를 좌표로 변환
    static List<int[]> beforeCalcPath(int[][] points, int[] route) {
        List<int[]> path = new ArrayList<>();
        
        int firstPointIndex = route[0]-1;
        path.add(new int[] {points[firstPointIndex][0], points[firstPointIndex][1]});
        
        for(int i=0;i<route.length-1;i++) {
            int[] start = points[route[i]-1];
            int[] end = points[route[i+1]-1];
            addMovePath(path, start, end);
        }
        return path;
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int robotCount = routes.length;
        List<List<int[]>> robotPaths = new ArrayList<>();
        
        for (int i = 0; i < robotCount; i++) {
            List<int[]> path = beforeCalcPath(points, routes[i]);
            robotPaths.add(path);
        }
        
        int maxTime = 0;
        for (List<int[]> path : robotPaths) {
            maxTime = Math.max(maxTime, path.size() - 1);
        }
        
        for(int time=0;time<=maxTime;time++) {
            Map<String, Integer> positionCount = new HashMap<>();
            for(int robot = 0; robot < robotCount;robot++) {
                List<int[]> path = robotPaths.get(robot);
                
                if(time<path.size()) {
                    int[] position = path.get(time);
                    String posKey = position[0]+","+position[1];
                    positionCount.put(posKey, positionCount.getOrDefault(posKey, 0)+1);
                }
            }
            
            for(int count: positionCount.values()) {
                if(count>=2) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}