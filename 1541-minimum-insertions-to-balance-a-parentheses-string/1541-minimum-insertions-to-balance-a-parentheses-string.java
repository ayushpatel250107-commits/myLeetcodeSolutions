class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int neededRight = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                neededRight += 2;
                if (neededRight % 2 == 1) {
                    insertions++;
                    neededRight--;
                }
            } else {
                neededRight--;
                if (neededRight < 0) {
                    insertions++;
                    neededRight += 2;
                }
            }
        }
        
        return insertions + neededRight;
    }
}
