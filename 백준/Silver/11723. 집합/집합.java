import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("add")){
                set.add(Integer.parseInt(st.nextToken()));
            } else if(s.equals("remove")){
                set.remove(Integer.parseInt(st.nextToken()));
            } else if(s.equals("check")){
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if(s.equals("toggle")){
                int temp = Integer.parseInt(st.nextToken());
                if(set.contains(temp)){
                    set.remove(temp);
                } else {
                    set.add(temp);
                }
            } else if(s.equals("all")){
                set.clear();
                for(int j=1;j<=20;j++){
                    set.add(j);
                }
            } else if(s.equals("empty")){
                set.clear();
            }
        }
        System.out.println(sb);
    }
}
