import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            
            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            
            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                results[i] = -1.0;
            } else if (src.equals(dest)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(src, dest, graph, visited);
            }
        }
        
        return results;
    }
    
    private double dfs(String current, String target, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (current.equals(target)) {
            return 1.0;
        }
        
        visited.add(current);
        Map<String, Double> neighbors = graph.get(current);
        
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            String nextNode = neighbor.getKey();
            double edgeWeight = neighbor.getValue();
            
            if (!visited.contains(nextNode)) {
                double productResult = dfs(nextNode, target, graph, visited);
                if (productResult != -1.0) {
                    return edgeWeight * productResult;
                }
            }
        }
        
        return -1.0;
    }
}
