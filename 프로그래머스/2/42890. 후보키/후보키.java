import java.util.*;

class Solution {
    static int[] a;
    static int[] b;
    static int N, R;
    static String[][] rel;
    static int answer = 0;
    static ArrayList<int[]> answerList = new ArrayList<>();
    
    static void comb(int start, int cnt) { // N 개 중에 R개 골라서 후보키 구성
        if(cnt==R) {
            if(isUnique()) {
                for(int[] arr:answerList) { // 최소성 체크
                    int num = arr.length;
                    int c = 0;
                    
                    for(int i:arr) {
                        for(int j:b) {
                            if(i==j) c++;
                        }
                    }
                    if(c==num) {
                        return;
                    }
                }
                answer++;
                answerList.add(b.clone());
            }
            return;
        }
        
        for(int i=start;i<N;i++) {
            b[cnt] = a[i];
            comb(i+1,cnt+1);
        }
    }
    
    // 유일성 체크
    static boolean isUnique() {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<rel.length;i++) {
            sb.setLength(0);
            for(int j:b) {
                sb.append(rel[i][j]);
            }
            if(set.contains(sb.toString())) {
                return false;
            } else {
                set.add(sb.toString());
            }
        }
        return true;
    }
    
    public int solution(String[][] relation) {
        rel = new String[relation.length][relation[0].length];
        for(int i=0;i<relation.length;i++) {
            for(int j=0;j<relation[0].length;j++) {
                rel[i][j] = relation[i][j];
            }
        }
        
        a = new int[relation[0].length];
        for(int i=0;i<relation[0].length;i++) {
            a[i] = i;
        }
        
        for(int n=1;n<=relation.length;n++) { // 후보키 구성 개수
            b = new int[n];
            N = a.length;
            R = n;
            comb(0,0);
        }
        
        return answer;
    }
}