import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static void search(int start, int end, int k) {
		while(start<=end) {
			int idx = (start+end)/2;
			if(arr[idx]>k){ // idx를 줄여야됨
				end = idx-1;
			} else if(arr[idx]<k){
				start = idx+1;
			} else{
//				 sb.append(idx+1).append(" ");
				sb.append(1).append("\n");
				return;
			}
		}
		sb.append(0).append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<m;i++) {
			int l = Integer.parseInt(st.nextToken()); // 찾고 싶은 숫자들
			search(0,n-1,l);
		}
		
		System.out.println(sb.toString());
	}
}