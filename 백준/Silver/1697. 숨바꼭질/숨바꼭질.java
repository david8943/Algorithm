import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int k;
	static boolean[] v = new boolean[100001];
	
	static int bfs(int x) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,0} );
		v[x] = true;
		int result = 0;
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			int cur = xy[0];
			int depth = xy[1];
			if(cur==k) {
				return depth;
			}
			if(cur-1>=0 && !v[cur-1]) {
				q.offer(new int[] {cur-1,depth+1});
				v[cur-1]=true;
			}
			if(cur+1<=100000 && !v[cur+1]) {
				q.offer(new int[] {cur+1,depth+1});
				v[cur+1]=true;
			}			
			if(2*cur<=100000 && !v[2*cur]) {
				q.offer(new int[] {2*cur,depth+1});
				v[2*cur]=true;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		// n에서 k로 이동하기
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		System.out.println(bfs(n));
	}
}
