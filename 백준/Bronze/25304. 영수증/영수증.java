import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sum = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int temp_sum=0;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());
            temp_sum+=price*quantity;
        }
        if(sum==temp_sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
