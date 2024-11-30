import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class GraphBuilder {
    Map<Integer, Set<Integer>> graph;

    private GraphBuilder() {
        graph = new HashMap<>();
    }

    public static GraphBuilder emptyGraph() {
        return new GraphBuilder();
    }

    public GraphBuilder edge(int u, int v) {
        if (!graph.containsKey(u)) graph.put(u, new HashSet<>());
        graph.get(u).add(v);
        return this;
    }

    public Map<Integer, Set<Integer>> build() {
        return graph;
    }
}
