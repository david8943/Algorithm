import java.io.*;
import java.util.*;

public class Main {
	static int n; // 컴퓨터 개수
	static boolean[][] arr; 
	static boolean[] v; // 방문 처리
	static int result;
	
	static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		v[start]=true;
		
		while(!q.isEmpty()) {
			int k = q.poll();
			for(int i=1;i<=n;i++) {
				if(arr[k][i]==true && !v[i]) {
					q.offer(i);
					v[i]=true;
					result++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		arr = new boolean[n+1][n+1];
		v = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			arr[temp1][temp2] = true;
			arr[temp2][temp1] = true;
		}
		
		bfs(1);
		System.out.println(result);
	}
}
