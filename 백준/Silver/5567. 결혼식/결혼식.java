import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[][] arr;
	static boolean[] v;
	static int result;
	
	static void bfs(int start) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, 0});
		v[start] = true;
		
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			int i = ij[0];
			int j = ij[1];
			for(int k=1;k<=n;k++) {
				if(arr[i][k]==true && !v[k]) {
					if(j+1==3)
						return;
					
					q.offer(new int[] {k,j+1});
					v[k]=true;
					result++;
				}
			}
		}
		return;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new boolean[n+1][n+1];
		v = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr[j][k] = true;
			arr[k][j] = true;
		}
		
		bfs(1);
		System.out.println(result);
	}
}
