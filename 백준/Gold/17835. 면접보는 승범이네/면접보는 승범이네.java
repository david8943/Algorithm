import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node> {
        int city;
        long dist;

        Node(int city, long dist) {
            this.city = city;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(v).add(new Edge(u, c));
        }

        st = new StringTokenizer(br.readLine());
        List<Integer> interviewCities = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            interviewCities.add(Integer.parseInt(st.nextToken()));
        }

        long[] dist = dijkstra(graph, interviewCities, N);

        long maxDist = 0;
        int farthestCity = 1;

        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                farthestCity = i;
            } else if (dist[i] == maxDist && i < farthestCity) {
                farthestCity = i;
            }
        }

        System.out.println(farthestCity);
        System.out.println(maxDist);
    }

    static long[] dijkstra(List<List<Edge>> graph, List<Integer> startCities, int N) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int city : startCities) {
            dist[city] = 0;
            pq.offer(new Node(city, 0));
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            long currentDist = current.dist;

            if (currentDist > dist[currentCity]) {
                continue;
            }

            for (Edge edge : graph.get(currentCity)) {
                int nextCity = edge.to;
                long newDist = currentDist + edge.cost;

                if (newDist < dist[nextCity]) {
                    dist[nextCity] = newDist;
                    pq.offer(new Node(nextCity, newDist));
                }
            }
        }

        return dist;
    }
}
