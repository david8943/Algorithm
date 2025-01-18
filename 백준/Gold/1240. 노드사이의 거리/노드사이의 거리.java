import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<int[]>[] graph; // 인접 리스트
    static boolean[] visited;
    static int result;

    static boolean dfs(int start, int aim, int dist) {
        if (start == aim) { // 목표 노드 도달
            result = dist;
            return true;
        }

        for (int[] edge : graph[start]) {
            int next = edge[0], weight = edge[1];
            if (!visited[next]) {
                visited[next] = true;
                if (dfs(next, aim, dist + weight)) return true; // 경로 찾으면 종료
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[x].add(new int[] { y, dist });
            graph[y].add(new int[] { x, dist });
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];
            visited[x] = true;
            dfs(x, y, 0);
            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}
