import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            // 문서의 개수 N과 몇 번째로 인쇄되었는지 궁금한 문서 M
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int result = 0;
            
            // Deque에 (중요도, 인덱스) 형태로 저장
            Deque<int[]> deque = new ArrayDeque<>();
            int[] check = new int[10]; // 1 이상 9 이하 정수
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                int temp = Integer.parseInt(st.nextToken());
                deque.offer(new int[]{temp, i}); // 중요도와 인덱스를 함께 저장
                check[temp]++;
            }

            while(true){
                int[] current = deque.pollFirst(); // 현재 문서 (중요도, 인덱스)
                int temp_num = current[0]; // 중요도
                int index = current[1]; // 인덱스
                boolean is_printed = true;

                // 현재 문서보다 높은 중요도가 있는지 확인
                for(int i = temp_num + 1; i < 10; i++){
                    if(check[i] != 0) {
                        // 인쇄하지 않고 큐 가장 뒤에 재배치
                        deque.offerLast(current);
                        is_printed = false;
                        break;
                    }
                }

                if(is_printed){
                    check[temp_num]--;
                    result++;
                    if(index == m){ // 찾고 있던 문서가 출력되었는지 확인
                        break;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
