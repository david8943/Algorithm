import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            HashMap<String, Integer> map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                if(map.containsKey(type)){
                    map.put(type, map.get(type)+1);
                }
                else{
                    map.put(type, 1);
                }
            }

            Collection<Integer> values = map.values();

            int result = 0;
            for (Integer value : values) {
                result = result + result*value + value;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }
}
