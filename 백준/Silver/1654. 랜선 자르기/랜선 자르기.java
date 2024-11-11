import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		int max_val = 0;
		for(int i=0;i<k;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max_val) max_val = arr[i];
		}
		long result = 0;
		long start = 1;
		long end = max_val;
		
		while(start<=end) {
			long temp_sum = 0;
			long mid = (start+end)/2;
			
			for(int i=0;i<k;i++) {
				temp_sum+=arr[i]/mid;
			}
			
			if (temp_sum<n) {
				end = mid-1;
			} else {
				start = mid+1;
				result = mid;
			}
		}
		
		System.out.println(result);
	}
}