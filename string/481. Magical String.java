class Solution {
    public int magicalString(int n) {
                // Initialize the magical string as a list with the first three numbers
        List<Integer> magicalStr = new ArrayList<>(Arrays.asList(1, 2, 2));

        // Use a pointer to iterate through the magical string to generate the next numbers
        int i = 2; // Starting from index 2 because the first three numbers are already in the list
        while (magicalStr.size() < n) {
            int lastNum = magicalStr.get(magicalStr.size() - 1); // Get the last number in the current magical string
            int nextNum = 3 - lastNum; // Calculate the next number (if lastNum is 1, then nextNum is 2; if lastNum is 2, then nextNum is 1)

            // Add 'nextNum' to the magical string 's.get(i)' times as per the current number's frequency
            for (int j = 0; j < magicalStr.get(i); ++j) {
                magicalStr.add(nextNum);
            }

            i++; // Move to the next number
        }

        // Count the number of occurrences of 1 in the first 'n' elements of the magical string
        int countOnes = 0;
        for (int idx = 0; idx < n; ++idx) {
            if (magicalStr.get(idx) == 1) {
                countOnes++;
            }
        }
      
        // Return the count of 1's in the first 'n' elements of the magical string
        return countOnes;
    }
}