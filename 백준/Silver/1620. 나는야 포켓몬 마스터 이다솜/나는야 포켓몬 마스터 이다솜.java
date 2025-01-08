import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 이름 -> 번호를 찾기 위한 HashMap
        HashMap<String, Integer> nameToNum = new HashMap<>();
        String[] arr = new String[n];

        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
            nameToNum.put(arr[i], i);
        }

        for(int i = 0; i < m; i++){
            String s = br.readLine();
            if(Character.isDigit(s.charAt(0))){
                sb.append(arr[Integer.parseInt(s)-1]).append("\n");
            } else {
                sb.append(nameToNum.get(s)+1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
