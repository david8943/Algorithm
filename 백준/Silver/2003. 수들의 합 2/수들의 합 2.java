import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int result = 0;
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 합이 M이 되는 경우
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int sum=0;
		int end=0;
		
		for(int start=0;start<N;start++) {
			while(sum<M && end<N) {
				sum+=arr[end];
				end+=1;
			}
			if(sum==M) {
				result+=1;
			}
			sum-=arr[start];
		}
		
		System.out.println(result);
	}
}
