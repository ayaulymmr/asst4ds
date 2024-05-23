import java.util.*;

public class DFS {
    private List<List<Integer>> adj;
    private int V;
    public DFS(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }
    public void dfs() {
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                visitVertex(v, visited);
            }
        }
    }
    private void visitVertex(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int w : adj.get(v)) {
            if (!visited[w]) {
                visitVertex(w, visited);
            }
        }
    }
    public static void main(String[] args) {
        DFS graph = new DFS(7);

        graph.addEdge(0, 2); // A -> C
        graph.addEdge(0, 1); // A -> B
        graph.addEdge(0, 3); // A -> D
        graph.addEdge(1, 0); // B -> A
        graph.addEdge(1, 2); // B -> C
        graph.addEdge(1, 4); // B -> E
        graph.addEdge(1, 6); // B -> G
        graph.addEdge(2, 0); // C -> A
        graph.addEdge(2, 1); // C -> B
        graph.addEdge(2, 3); // C -> D
        graph.addEdge(3, 2); // D -> C
        graph.addEdge(3, 0); // D -> A
        graph.addEdge(4, 6); // E -> G
        graph.addEdge(4, 5); // E -> F
        graph.addEdge(4, 1); // E -> B
        graph.addEdge(5, 6); // F -> G
        graph.addEdge(5, 4); // F -> E
        graph.addEdge(6, 5); // G -> F
        graph.addEdge(6, 1); // G -> B

        System.out.println("DFS traversal:");
        graph.dfs();
    }
}



