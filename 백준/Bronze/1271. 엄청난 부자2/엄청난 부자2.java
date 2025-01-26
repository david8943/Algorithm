import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력값을 BigInteger로 변환
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        // 몫과 나머지 계산
        BigInteger r1 = n.divide(m);
        BigInteger r2 = n.remainder(m);

        // 결과 출력
        System.out.println(r1);
        System.out.println(r2);
    }
}
