class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int monsterCount = dist.length; // Number of monsters
        int[] arrivalTimes = new int[monsterCount]; // Store times when each monster will arrive
      
        // Calculate the arrival time for each monster, rounded down
        for (int i = 0; i < monsterCount; ++i) {
            // '-1' because we can defeat a monster at the start of the time unit before it reaches us
            arrivalTimes[i] = (dist[i] - 1) / speed[i];
        }
      
        // Sort the monsters by their arrival times in ascending order
        Arrays.sort(arrivalTimes);
      
        // Go through the sorted list to find how many monsters can be eliminated
        for (int i = 0; i < monsterCount; ++i) {
            // If a monster's arrival time is less than the time units spent, you can't eliminate it
            if (arrivalTimes[i] < i) {
                return i; // Return the number of monsters defeated before the player is caught
            }
        }
      
        // If all monsters' arrival times are greater than or equal to time spent, all can be defeated
        return monsterCount;
    }
}