class Solution {
  
    // This method counts all the lattice points that are inside or on the perimeter of the given circles.
    // Each circle is represented by an array with three integers: [x_center, y_center, radius].
    public int countLatticePoints(int[][] circles) {
        // 'maxX' and 'maxY' are used to determine the size of the grid to check for lattice points.
        int maxX = 0, maxY = 0;
      
        // Calculate the furthest x and y coordinates that we need to check, by looking at the circle
        // with the largest x + radius and y + radius.
        for (var circle : circles) {
            maxX = Math.max(maxX, circle[0] + circle[2]);
            maxY = Math.max(maxY, circle[1] + circle[2]);
        }
      
        // 'count' will store the total number of lattice points.
        int count = 0;
      
        // Check each point in the grid.
        for (int x = 0; x <= maxX; ++x) {
            for (int y = 0; y <= maxY; ++y) {
                // Check if this point is within or on any of the circles.
                for (var circle : circles) {
                    int deltaX = x - circle[0];
                    int deltaY = y - circle[1];
                    // Check if the point (x, y) is inside the circle by comparing the square of the distance
                    // from (x, y) to the circle's center with the square of the circle's radius.
                    if (deltaX * deltaX + deltaY * deltaY <= circle[2] * circle[2]) {
                        // If the point is in the circle, increment the count and move to the next point.
                        ++count;
                        break; // Move to the next point since we only need to count each point once.
                    }
                }
            }
        }
      
        // Return the total count of lattice points.
        return count;
    }
}