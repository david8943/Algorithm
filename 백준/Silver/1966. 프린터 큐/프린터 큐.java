import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            // 문서의 개수 N과 몇 번째로 인쇄되었는지 궁금한 문서 M
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int result = 0;
            Deque<Integer> deque = new ArrayDeque<>();
            int[] check = new int[10]; // 1 이상 9 이하 정수
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                int temp = Integer.parseInt(st.nextToken());
                deque.offer(temp);
                check[temp]++;
            }

            while(true){
                int temp_num = deque.pollFirst();
                boolean is_printed = true;

                for(int i=temp_num+1;i<10;i++){
                    if(check[i]!=0) {
                        // 인쇄하지 않고 큐 가장 뒤에 재배치
                        deque.offerLast(temp_num);
                        is_printed = false;
                        break;
                    }
                }
                if(is_printed){
                    check[temp_num]--;
                    result++;
//                    System.out.println("print "+temp_num);
                    if(m==0){
                        break;
                    }
                }
                // 출력이 안됐으면 m 인덱스 조정
                if(m==0){
                    m = deque.size()-1;
                } else {
                    m--;
                }
            }
//            System.out.println("result "+result);
            System.out.println(result);
        }
    }
}
