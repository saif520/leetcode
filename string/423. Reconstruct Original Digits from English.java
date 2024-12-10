class Solution {
    public String originalDigits(String s) {
        // Create an array to keep count of all alphabet characters within the string
        int[] charCounter = new int[26];
        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            charCounter[c - 'a']++;
        }

        // Create an array to count the occurrences of each digit (0-9) in the string
        int[] digitCounts = new int[10];

        // Count unique letters that only appear in a single number's spelling.
        // This gives us a definitive count of certain digits.
        digitCounts[0] = charCounter['z' - 'a']; // Zero
        digitCounts[2] = charCounter['w' - 'a']; // Two
        digitCounts[4] = charCounter['u' - 'a']; // Four
        digitCounts[6] = charCounter['x' - 'a']; // Six
        digitCounts[8] = charCounter['g' - 'a']; // Eight

        // For other numbers which share letters, we subtract the counts of 
        // already identified unique ones to get the correct digit counts.
        digitCounts[3] = charCounter['h' - 'a'] - digitCounts[8];  // Three (h is also in eight)
        digitCounts[5] = charCounter['f' - 'a'] - digitCounts[4];  // Five (f is also in four)
        digitCounts[7] = charCounter['s' - 'a'] - digitCounts[6];  // Seven (s is also in six)

        // For one and nine, we deduce their counts by subtracting the counts of digits
        // that share the same letters and have been previously determined.
        digitCounts[1] = charCounter['o' - 'a'] - digitCounts[0] - digitCounts[2] - digitCounts[4]; // One
        digitCounts[9] = charCounter['i' - 'a'] - digitCounts[5] - digitCounts[6] - digitCounts[8]; // Nine

        // Construct the final digits string in ascending order.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < digitCounts[i]; ++j) {
                result.append(i);
            }
        }

        // Return the constructed string which represents the original digits in ascending order.
        return result.toString();
    }
}