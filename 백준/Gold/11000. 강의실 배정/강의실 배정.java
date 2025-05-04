import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<int[]> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr.add(new int[]{s,t});
        }

        Collections.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr.get(0)[1]);

        for(int i=1;i<arr.size();i++){
            int end = pq.poll();
            int start = arr.get(i)[0];
            if(start<end) {
                pq.add(end);
            }
            pq.add(arr.get(i)[1]);
        }

        System.out.println(pq.size());
    }
}
