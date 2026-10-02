import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {entrance[0], entrance[1], 0});
        
        maze[entrance[0]][entrance[1]] = '+';
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];
            
            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                    if (maze[nextRow][nextCol] == '.') {
                        if (nextRow == 0 || nextRow == m - 1 || nextCol == 0 || nextCol == n - 1) {
                            return steps + 1;
                        }
                        
                        maze[nextRow][nextCol] = '+';
                        queue.offer(new int[] {nextRow, nextCol, steps + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}
