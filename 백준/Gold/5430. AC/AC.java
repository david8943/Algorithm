import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String order = br.readLine();
            int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수 개수

            String s = br.readLine();
            s = s.substring(1, s.length()-1);
            String[] sarr = s.split(",");

            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(sarr[i]));
            }

            Boolean isError = false;
            Boolean isReversed = false;
            
            for(int i = 0; i < order.length(); i++) {
                if(order.charAt(i) == 'R') {
                    isReversed = !isReversed;
                } else if(order.charAt(i) == 'D') {
                    if(deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if(isReversed) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
//                for (int num : deque) {
//                    System.out.print(num+" ");
//                }
//                System.out.println();
            }

            if(isError) {
                sb.append("error").append('\n');
            } else {
                int dequeSize = deque.size();
                if(isReversed) {
                    sb.append("[");
                    for(int i = 0; i < dequeSize-1; i++) {
                        sb.append(deque.pollLast());
                        sb.append(",");
                    }
                    if(dequeSize>0) sb.append(deque.pollLast());
                    sb.append("]").append("\n");
                } else {
                    sb.append("[");
                    for(int i = 0; i < dequeSize-1; i++) {
                        sb.append(deque.pollFirst());
                        sb.append(",");
                    }
                    if(dequeSize>0) sb.append(deque.pollFirst());
                    sb.append("]").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
