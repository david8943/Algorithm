import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void find(int a, int b) {
        StringBuilder[] sbArray = new StringBuilder[10000];
        boolean[] v = new boolean[10000];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.offer(a);
        sbArray[a] =  new StringBuilder();
        v[a] = true;
        int dn, ds, dl, dr;

        while(!v[b]){
            int n = deque.poll();

            dn = n*2%10000;
            ds = n-1;
            if(ds==-1) ds=9999;
            dl = (n%1000)*10 + n/1000;
            dr = (n%10)*1000 + n/10;

            if(!v[dn]) {
                v[dn] = true;
                sbArray[dn] = new StringBuilder(sbArray[n]).append("D");
                deque.offer(dn);
            }
            if(!v[ds]) {
                v[ds] = true;
                sbArray[ds] = new StringBuilder(sbArray[n]).append("S");
                deque.offer(ds);
            }
            if(!v[dl]) {
                v[dl] = true;
                sbArray[dl] = new StringBuilder(sbArray[n]).append("L");
                deque.offer(dl);
            }
            if(!v[dr]) {
                v[dr] = true;
                sbArray[dr] = new StringBuilder(sbArray[n]).append("R");
                deque.offer(dr);
            }
        }
        sb.append(sbArray[b]).append("\n");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int T=0;T<t;T++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            find(a,b);
        }
        System.out.println(sb);
    }
}
