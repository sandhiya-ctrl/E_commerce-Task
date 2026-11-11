
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Microservice {

    static void addEdge(
            Map<String, List<String>> graph,
            String from,
            String to) {

        graph.get(from).add(to);
    }

    static void bfs(
            Map<String, List<String>> graph,
            String start) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        System.out.println("BFS Traversal:");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String next : graph.get(current)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
        System.out.println();
    }

    static void dfs(
            Map<String, List<String>> graph,
            String current,
            Set<String> visited) {

        visited.add(current);
        System.out.print(current + " ");

        for (String next : graph.get(current)) {
            if (!visited.contains(next)) {
                dfs(graph, next, visited);
            }
        }
    }

    public static void main(String[] args) {

        Map<String, List<String>> graph = new LinkedHashMap<>();

        graph.put("Cart", new ArrayList<>());
        graph.put("Pricing", new ArrayList<>());
        graph.put("Inventory", new ArrayList<>());
        graph.put("Payment", new ArrayList<>());
        graph.put("Shipping", new ArrayList<>());

        addEdge(graph, "Cart", "Pricing");
        addEdge(graph, "Pricing", "Inventory");
        addEdge(graph, "Inventory", "Payment");
        addEdge(graph, "Payment", "Shipping");

        bfs(graph, "Cart");

        System.out.println("DFS Traversal:");
        dfs(graph, "Cart", new HashSet<>());
        System.out.println();
    }
}
