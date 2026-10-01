import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] c : connections) {
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(-c[0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(0);
        visited[0] = true;
        int changeCount = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int neighbor : adj.get(curr)) {
                int nextNode = Math.abs(neighbor);
                
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    if (neighbor > 0) {
                        changeCount++;
                    }
                    queue.offer(nextNode);
                }
            }
        }
        
        return changeCount;
    }
}
