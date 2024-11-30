import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        int res = 0;

        int temp1 = s1.charAt(0)-'0';
        int temp2 = s2.charAt(0)-'0';

        if (temp1>=0 && temp1<=9){
            res= Integer.parseInt(s1)+3;
        } else if (temp2>=0 && temp2<=9){
            res= Integer.parseInt(s2)+2;
        } else {
            res= Integer.parseInt(s3)+1;
        }

        if (res%3==0 && res%5==0){
            System.out.println("FizzBuzz");
        } else if (res%3==0){
            System.out.println("Fizz");
        } else if (res%5==0){
            System.out.println("Buzz");
        } else {
            System.out.println(res);
        }
    }
}