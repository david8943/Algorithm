import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int n;
	static int[] result = new int[6];
	static StringBuilder sb = new StringBuilder();
	
	static void bb(int start, int cnt) {
		if(cnt == 6) {
			for(int i=0;i<6;i++) {
				sb.append(result[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<n;i++) {
			result[cnt]=arr[i];
			bb(i+1,cnt+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			if(n==0) {
				break;
			} else {
				arr = new int[n];
			}
			
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			bb(0,0);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
