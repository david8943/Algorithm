import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static boolean bfs(int x, int y) {
		 v = new boolean[12][6];
		 ArrayDeque<int[]> q = new ArrayDeque();
		 q.offer(new int[] {x,y});
		 int color = map[x][y];
		 int cnt = 0;
		 while(!q.isEmpty()) {
			 int[] ij = q.poll();
			 int i = ij[0];
			 int j = ij[1];
			 for(int d=0;d<4;d++) {
				 int nx = i + dx[d];
				 int ny = j + dy[d];
				 if(0<=nx&&nx<12 && 0<=ny&&ny<6 && map[nx][ny]==color && !v[nx][ny]) {
					 q.offer(new int[] {nx,ny});
					 v[nx][ny]=true; 
					 cnt++;
				 }
			 }
			 if(cnt>=4) return true;
		 }
		 return false;
	}
	
	static void pop(int x, int y) {
		v = new boolean[12][6];
		 ArrayDeque<int[]> q = new ArrayDeque();
		 q.offer(new int[] {x,y});
		 int color = map[x][y];
		 map[x][y]=0;
		 while(!q.isEmpty()) {
			 int[] ij = q.poll();
			 int i = ij[0];
			 int j = ij[1];
			 for(int d=0;d<4;d++) {
				 int nx = i + dx[d];
				 int ny = j + dy[d];
				 if(0<=nx&&nx<12 && 0<=ny&&ny<6 && map[nx][ny]==color && !v[nx][ny]) {
					 map[nx][ny]=0;
					 v[nx][ny]=true;
					 q.offer(new int[] {nx,ny});
				 }
			 }
		 }
	}
	
	static void down() {
		// 아래로 내리기
		for(int j=0;j<6;j++) {
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for(int i=11;i>=0;i--) {
				if(map[i][j]!=0) q.offer(map[i][j]);
			}
			
			int size = q.size();
			
			for(int i=11;i>11-size;i--) {
				map[i][j]=q.poll();
			}
			for(int i=11-size;i>=0;i--) {
				map[i][j]=0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		map = new int[12][6];
		
		for(int i=0;i<12;i++) {
			String temp = br.readLine();
			for(int j=0;j<6;j++) {
				if (temp.charAt(j)=='R') map[i][j]=1;
				else if (temp.charAt(j)=='G') map[i][j]=2;
				else if (temp.charAt(j)=='B') map[i][j]=3;
				else if (temp.charAt(j)=='P') map[i][j]=4;
				else if (temp.charAt(j)=='Y') map[i][j]=5;
			}
		}
		
		// 터트리기
		int anw=0;
		
		while(true) {			
			boolean is_pop=false;
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(map[i][j]!=0) {
						if (bfs(i,j)) { // 터트릴게 있으면
							is_pop=true; // 그 턴에 터트렸다고 표시
							pop(i,j); // 터트렸다
						}
					}
				}
			}
			down(); // 아래로 내리기
			if(is_pop) anw++;
			else break;
		}
		System.out.println(anw);
	}
}
