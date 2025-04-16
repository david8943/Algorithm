import java.io.*;
import java.util.*;

public class Main {
    static int[] map;

    static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{1, 0});

        while(!q.isEmpty()) {
            int[] cq = q.poll();
            int start = cq[0];
            int cnt = cq[1];
//            System.out.println("start: " + start + " cnt: " + cnt);

            if(start>=100) {
                return cnt;
            }

            boolean[] arr = new boolean[7];
            for(int i=1;i<=6;i++){
                if(map[start+i]>0) { // 사다리나 뱀 타는 경우
                    q.offer(new int[] {map[start+i],cnt+1});
//                    System.out.println("사다리나 뱀: "+start+i+" "+cnt+1);
                    arr[i] = true;
                }
            }

            int maxLeft = 6; // 사다리나 뱀 제외한 최대 지점
            for(int i=6;i>=1;i--){
                if(arr[i]) maxLeft = i-1;
                else break;
            }

            if(maxLeft > 0) {
                q.offer(new int[] {start+maxLeft,cnt+1});
//                System.out.println("사다리나 뱀 제외: "+start+maxLeft+" "+cnt+1);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[106];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n+m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start]=end;
        }

        System.out.println(bfs());
    }
}
