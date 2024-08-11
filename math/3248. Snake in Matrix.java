class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;  // row index
        int j = 0;  // column index
        
        for (int k = 0; k < commands.size(); k++) {
            if (commands.get(k).equals("RIGHT")) {
                j++;
            } else if (commands.get(k).equals("UP")) {
                i--;
            } else if (commands.get(k).equals("DOWN")) {
                i++;
            } else if (commands.get(k).equals("LEFT")) {
                j--;
            }
        }
        
        return (i * n) + j;
    }
}