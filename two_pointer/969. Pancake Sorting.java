class Solution {
    /**
     * Sorts an array using pancake sort algorithm.
     * Pancake sort works by repeatedly finding the maximum element and flipping it to its correct position.
     * 
     * @param arr The input array to be sorted
     * @return List of flip positions (k-values) that will sort the array
     */
    public List<Integer> pancakeSort(int[] arr) {
        int arrayLength = arr.length;
        List<Integer> flipPositions = new ArrayList<>();
      
        // Process from the largest element to the smallest
        // Place each element at its correct position from right to left
        for (int currentTargetIndex = arrayLength - 1; currentTargetIndex > 0; currentTargetIndex--) {
            // Find the position of the element that should be at currentTargetIndex
            // The target value is (currentTargetIndex + 1) since array is 1-indexed in value
            int targetValue = currentTargetIndex + 1;
            int currentPosition = currentTargetIndex;
          
            // Search for the target value in the unsorted portion
            while (currentPosition > 0 && arr[currentPosition] != targetValue) {
                currentPosition--;
            }
          
            // If the element is not already in its correct position
            if (currentPosition < currentTargetIndex) {
                // First flip: bring the target element to the front (if not already there)
                if (currentPosition > 0) {
                    flipPositions.add(currentPosition + 1);  // Add 1 for 1-indexed flip position
                    reverse(arr, currentPosition);
                }
              
                // Second flip: move the element from front to its correct position
                flipPositions.add(currentTargetIndex + 1);  // Add 1 for 1-indexed flip position
                reverse(arr, currentTargetIndex);
            }
        }
      
        return flipPositions;
    }
  
    /**
     * Reverses the first (endIndex + 1) elements of the array.
     * This simulates a pancake flip operation.
     * 
     * @param arr The array to perform the flip on
     * @param endIndex The index up to which elements should be reversed (inclusive)
     */
    private void reverse(int[] arr, int endIndex) {
        int startIndex = 0;
      
        // Swap elements from both ends moving towards the center
        while (startIndex < endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
          
            startIndex++;
            endIndex--;
        }
    }
}
