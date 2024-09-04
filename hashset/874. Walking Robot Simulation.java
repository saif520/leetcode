class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions for moving on the grid: North, East, South, West
        int[] directionDeltas = {0, 1, 0, -1, 0};
        // Set to store obstacle coordinates in encoded form
        Set<Integer> obstacleSet = new HashSet<>(obstacles.length);
        // Encode and add obstacles to the set
        for (int[] obstacle : obstacles) {
            obstacleSet.add(encodePosition(obstacle[0], obstacle[1]));
        }
        int maxDistanceSquared = 0; // Will hold the maximum squared distance from the origin
        int directionIndex = 0; // Direction index points to the current direction
        int x = 0, y = 0; // Robot's starting position at the origin (0, 0)
        // Process each command to move the robot
        for (int command : commands) {
            if (command == -2) { // Turn left
                directionIndex = (directionIndex + 3) % 4;
            } else if (command == -1) { // Turn right
                directionIndex = (directionIndex + 1) % 4;
            } else {
                // Move the robot forward by the number of steps specified by command
                while (command-- > 0) {
                    int nextX = x + directionDeltas[directionIndex];
                    int nextY = y + directionDeltas[directionIndex + 1];
                    // Check if the next position is an obstacle
                    if (obstacleSet.contains(encodePosition(nextX, nextY))) {
                        break; // Stop moving if an obstacle is encountered
                    }
                    // Update the robot's position
                    x = nextX;
                    y = nextY;
                    // Calculate the squared distance from the origin and update maximum if necessary
                    maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
                }
            }
        }
        return maxDistanceSquared; // Return the maximum squared distance from the origin
    }

    // Helper method to encode a 2D grid position into a single integer.
    // This is a common trick to store pairs as keys in a HashSet or HashMap.
    // Here, we make the assumption that -30000 <= x,y <= 30000.
    private int encodePosition(int x, int y) {
        return x * 60010 + y;
    }
}