import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;
    static ArrayList<Square> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        arr.add(new Square(0,0,0,0));

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            arr.add(new Square(x1, x2, y1, y2));
        }

        for(int i=0;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                if(meet(arr.get(i), arr.get(j))) {
                    makeUnion(i, j);
                }
            }
        }

        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<=n;i++) {
            hs.add(findP(i));
        }

        System.out.println(hs.size()-1);
    }

    static boolean meet(Square a, Square b) {
        if(a.y2>b.y2 && b.x2<a.x2 && b.y1>a.y1 && b.x1>a.x1)
            return false;
        if(a.y2<b.y2 && b.x2>a.x2 && b.y1<a.y1 && b.x1<a.x1)
            return false;
        if(a.y2<b.y1 || a.x2<b.x1 || a.y1>b.y2 || a.x1>b.x2)
            return false;
        return true;
    }

    static int findP(int i) {
        if(parent[i] == i)
            return i;
        else
            return findP(parent[i]);
    }

    static void makeUnion(int i, int j) {
        i = findP(i);
        j = findP(j);
        if(i<j) parent[j]=i;
        else if(i>j) parent[i]=j;
    }
}

class Square {
    int x1, x2, y1, y2;
    public Square(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}