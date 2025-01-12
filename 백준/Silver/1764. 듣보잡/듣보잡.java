import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet set = new HashSet();
        List<String> saved = new ArrayList<>();
        int result = 0;

        for(int i=0;i<n;i++){
            String temp = br.readLine();
            set.add(temp);
        }

        for(int i=0;i<m;i++){
            String temp = br.readLine();
            if(set.contains(temp)){
                result++;
                saved.add(temp);
            }
        }

        sb.append(result).append("\n");

        Collections.sort(saved);
        for(String word : saved) {
            sb.append(word).append("\n");
        }

        System.out.println(sb.toString());
    }
}
