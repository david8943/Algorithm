import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        int cur_num = 0; // 지금 0까지 origin에서 뽑아냈음
        Boolean isPossible = true;
        for(int i=0;i<n;i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp>=cur_num){
                for(int j=cur_num+1;j<=temp;j++){
                    deque.push(j);
                    sb.append("+").append("\n");
                }
                deque.pop();
                sb.append("-").append("\n");
                cur_num = temp; // 지금 temp까지는 orgin에서 뽑아냈음
            }
            else if(temp == deque.peek()){
                deque.pop();
                sb.append("-").append("\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if(isPossible){
            System.out.println(sb.toString());
        } else{
            System.out.println("NO");
        }
    }
}
