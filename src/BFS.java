import java.util.*;

public class BFS {
    private List<List<Integer>> adj;
    private int V;

    public BFS(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int w : adj.get(u)) {
                if (!visited[w]) {
                    visited[w] = true;
                    q.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS(7);

        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 6);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 0);
        graph.addEdge(4, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 1);
        graph.addEdge(5, 6);
        graph.addEdge(5, 4);
        graph.addEdge(6, 5);
        graph.addEdge(6, 1);

        System.out.println("BFS traversal:");
        graph.bfs(0);
    }
}

