class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        
        int max = Integer.MIN_VALUE;
        int resultLevel = 1;
        int currentLevel = 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            currentLevel++;
            int levelSize = queue.size();
            int currentSum = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentSum += node.val;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            if (currentSum > max) {
                max = currentSum;
                resultLevel = currentLevel;
            }
        }
        
        return resultLevel;
    }
}
