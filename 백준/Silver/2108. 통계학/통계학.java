import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] cnt = new int[9001];
        int sum = 0;
        int max = -10000;
        int min = 10000;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            cnt[arr[i]+4000]++;
            sum += arr[i];
            if(max < arr[i]) max = arr[i];
            if(min > arr[i]) min = arr[i];
        }

        // 산술평균
        double avg = (double)sum/n;
        System.out.println(Math.round(avg));

        // 중앙값
        Arrays.sort(arr);
        System.out.println(arr[n/2]);

        // 최빈값
        int max_cnt = 0;
        for(int i=0;i<9001;i++){
            if(max_cnt < cnt[i]) max_cnt = cnt[i];
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<9001;i++){
            if(max_cnt == cnt[i]) {
                list.add(i-4000);
            }
        }
        Collections.sort(list);
//        System.out.println(list);

        if(list.size() == 1) System.out.println(list.get(0));
        else System.out.println(list.get(1));

        // 범위
        System.out.println(max - min);
    }

}