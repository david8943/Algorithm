import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        int primeCount = 0;

        for(int i=2; i*i<=N; i++){
            if(isPrime[i]){
                for(int j=i*i;j<=N;j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2;i<=N;i++) {
            if(isPrime[i]){
                primeCount++;
            }
        }
        int[] primeArray = new int[primeCount];
        int idx = 0;
        for(int i=2; i<=N; i++){
            if(isPrime[i]){
                primeArray[idx++] = i;
            }
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;

        while(right < primeCount){
            sum += primeArray[right];
            right++;

            while(sum >= N) {
                if(sum == N) {
                    answer++;
                }

                sum -= primeArray[left];
                left++;
            }
        }

        System.out.println(answer);
    }
}
