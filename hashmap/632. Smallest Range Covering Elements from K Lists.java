class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
         // Count total elements from all the lists
        int totalElements = 0;
        for (List<Integer> list : nums) {
            totalElements += list.size();
        }
      
        // Initialize an array to store elements and their corresponding list indices
        int[][] elementsWithIndex = new int[totalElements][2];
        int numLists = nums.size();
      
        // Populate the array with elements from the lists
        for (int i = 0, currentIndex = 0; i < numLists; ++i) {
            for (int num : nums.get(i)) {
                elementsWithIndex[currentIndex++] = new int[] {num, i};
            }
        }
      
        // Sort the array based on the numeric value of elements
        Arrays.sort(elementsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));
      
        Map<Integer, Integer> count = new HashMap<>();
        int[] answer = new int[] {-1000000, 1000000};
        int start = 0;
      
        // Iterate through the elements to find the smallest range
        for (int[] elementAndIndex : elementsWithIndex) {
            int endValue = elementAndIndex[0];
            int listIndex = elementAndIndex[1];
          
            // Increment the count for this list index
            count.put(listIndex, count.getOrDefault(listIndex, 0) + 1);
          
            // While all lists are represented in the current window
            while (count.size() == numLists) {
                int startValue = elementsWithIndex[start][0];
                int startIndex = elementsWithIndex[start][1];
              
                // Check if we have found a smaller range
                int rangeDiff = endValue - startValue - (answer[1] - answer[0]);
                if (rangeDiff < 0 || (rangeDiff == 0 && startValue < answer[0])) {
                    answer[0] = startValue;
                    answer[1] = endValue;
                }
              
                // Decrement the count for this list index and potentially remove it
                count.put(startIndex, count.get(startIndex) - 1);
                if (count.get(startIndex) == 0) {
                    count.remove(startIndex);
                }
              
                // Move the start of the window to the right
                ++start;
            }
        }
        return answer;
    }
}