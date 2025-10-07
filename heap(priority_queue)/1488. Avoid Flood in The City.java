class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        // Initialize all days with -1 (default for rainy days)
        Arrays.fill(result, -1);
      
        // TreeSet to store indices of sunny days (when rains[i] == 0)
        // Using TreeSet for efficient search of the next available sunny day
        TreeSet<Integer> sunnyDays = new TreeSet<>();
      
        // Map to store the last occurrence index of each lake that was filled
        // Key: lake number, Value: day index when it last rained on this lake
        Map<Integer, Integer> lastRainedLakes = new HashMap<>();
      
        for (int day = 0; day < n; day++) {
            int lake = rains[day];
          
            if (lake > 0) {
                // It's raining on this lake
                if (lastRainedLakes.containsKey(lake)) {
                    // This lake was already full, we need to dry it before today
                    // Find the first sunny day after the last time it rained on this lake
                    Integer dryDay = sunnyDays.higher(lastRainedLakes.get(lake));
                  
                    if (dryDay == null) {
                        // No sunny day available to dry this lake - flooding occurs
                        return new int[0];
                    }
                  
                    // Use this sunny day to dry the current lake
                    result[dryDay] = lake;
                    sunnyDays.remove(dryDay);
                }
                // Update the last rained day for this lake
                lastRainedLakes.put(lake, day);
            } else {
                // It's a sunny day, add to available sunny days
                sunnyDays.add(day);
                // Temporarily set to 1 (can be any positive number if not used)
                result[day] = 1;
            }
        }
      
        return result;
    }
}