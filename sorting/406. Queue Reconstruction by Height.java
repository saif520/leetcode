class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort the array. First, sort by height in descending order.
        // If heights are equal, sort by the number of people in front (k-value) in ascending order.
        Arrays.sort(people, (person1, person2) ->
            person1[0] == person2[0] ? person1[1] - person2[1] : person2[0] - person1[0]);

        // Initialize a list to hold the final queue reconstruction,
        // which allows us to insert people at specific indices.
        List<int[]> reconstructedQueue = new ArrayList<>(people.length);
      
        // Iterate over the sorted array, and insert each person into the list
        // at the index specified by their k-value.
        for (int[] person : people) {
            // The second value of each person array (person[1])
            // specifies the index at which this person should be added in the queue
            reconstructedQueue.add(person[1], person);
        }
      
        // Convert the list back to an array before returning it.
        return reconstructedQueue.toArray(new int[reconstructedQueue.size()][]);
    }
}