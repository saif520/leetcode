class Solution {
  
    // Main method to check if a prime subtraction operation can make the array strictly increasing.
    public boolean primeSubOperation(int[] nums) {
        // Generate a list of prime numbers up to 1000
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= 1000; ++num) {
            boolean isPrime = true;
            for (int prime : primes) {
                if (num % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
        }

        int length = nums.length;
      
        // Iterate over the array from the end to start
        for (int i = length - 2; i >= 0; --i) {
          
            // Continue if the current number is less than the next (array is already increasing here)
            if (nums[i] < nums[i + 1]) {
                continue;
            }
          
            // Use binary search to find the smallest prime such that it's less than the difference
            int index = binarySearch(primes, nums[i] - nums[i + 1]);
          
            // If the prime is not found or greater than or equal to the current number, return false
            if (index == primes.size() || primes.get(index) >= nums[i]) {
                return false;
            }
          
            // Subtract the prime number found from the current array element
            nums[i] -= primes.get(index);
        }
      
        // If no issues found, return true
        return true;
    }

    // Helper method to perform binary search and find the smallest prime number greater than x
    private int binarySearch(List<Integer> primes, int x) {
        int left = 0, right = primes.size();
        while (left < right) {
            int mid = (left + right) >> 1; // Equivalent to (left + right) / 2 but avoids overflow
            if (primes.get(mid) > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // Return the index of the smallest prime number greater than x
        return left;
    }
}