import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2]; // N+1일까지 고려해야 하므로 N+2 크기로 설정

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            int nextDay = i + T[i]; // 해당 상담을 끝낸 다음 날

            if (nextDay <= N + 1) { // 상담을 진행할 수 있는 경우
                dp[i] = Math.max(P[i] + dp[nextDay], dp[i + 1]);
            } else { // 상담을 진행할 수 없는 경우
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}