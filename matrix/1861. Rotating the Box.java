class Solution {

    // Method to rotate the box and let the stones fall down due to gravity
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length; // Number of rows in the box
        int cols = box[0].length; // Number of columns in the box
        char[][] rotatedBox = new char[cols][rows]; // Resultant array after rotation

        // Rotate the box by 90 degrees clockwise. The bottom becomes the right side.
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                rotatedBox[col][rows - row - 1] = box[row][col];
            }
        }
      
        // Simulate gravity after rotation. Stones fall down to the bottom (right side of the original box).
        for (int col = 0; col < rows; ++col) {
            Deque<Integer> emptySpaces = new ArrayDeque<>(); // Queue to track empty spaces (.)
            for (int row = cols - 1; row >= 0; --row) {
                // If there's an obstacle, clear the queue as we can't move stones across obstacles.
                if (rotatedBox[row][col] == '*') {
                    emptySpaces.clear();
                }
                // If the cell is empty, keep track of the row index.
                else if (rotatedBox[row][col] == '.') {
                    emptySpaces.offer(row);
                }
                // If there's a stone, move it down if there's an empty space under it.
                else if (!emptySpaces.isEmpty()) {
                    rotatedBox[emptySpaces.pollFirst()][col] = '#'; // Move stone to the next empty space.
                    rotatedBox[row][col] = '.'; // Make the original place of the stone empty.
                    emptySpaces.offer(row); // Now the old place of the stone is an empty space.
                }
            }
        }
        return rotatedBox; // Return the box after rotation and gravity simulation
    }
}