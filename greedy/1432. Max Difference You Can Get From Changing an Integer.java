class Solution {
    public int maxDiff(int num) {
                // Convert the integer to a String for easier manipulation.
        String numStr = String.valueOf(num);
        // Create two copies of the string, one for the maximum value and one for the minimum.
        String maxNumStr = numStr;
        String minNumStr = numStr;

        // Find the first non-'9' digit and replace all its occurrences with '9' to get the maximum number.
        for (int i = 0; i < numStr.length(); ++i) {
            if (numStr.charAt(i) != '9') {
                maxNumStr = numStr.replace(numStr.charAt(i), '9');
                break;
            }
        }

        // For minimum number, if the first digit is not '1', replace all its occurrences with '1'.
        if (minNumStr.charAt(0) != '1') {
            minNumStr = minNumStr.replace(minNumStr.charAt(0), '1');
        } else {
            // If the first digit is '1', find the first digit that is not '0' or '1' from the second digit onwards
            // and replace all its occurrences with '0'.
            for (int i = 1; i < minNumStr.length(); ++i) {
                if (minNumStr.charAt(i) != '0' && minNumStr.charAt(i) != '1') {
                    minNumStr = minNumStr.replace(minNumStr.charAt(i), '0');
                    break;
                }
            }
        }
      
        // Parse the max and min strings back to integers and return the difference.
        return Integer.parseInt(maxNumStr) - Integer.parseInt(minNumStr);
    }
}