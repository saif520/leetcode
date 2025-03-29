import java.util.*;

class Solution {
    private final int MODULO = (int) 1e9 + 7;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        // Creating a 2D array to store index, number of prime factors, and the actual number
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {i, countPrimeFactors(nums.get(i)), nums.get(i)};
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        // Calculate left limits for every element
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()][1] < arr[i][1]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        // Calculate right limits for every element
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()][1] <= arr[i][1]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        // Sort the array in decreasing order of the actual number
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);
        long answer = 1;
        for (int[] elem : arr) {
            int index = elem[0];
            int value = elem[2];
            int leftLimit = left[index];
            int rightLimit = right[index];
            long count = (long) (index - leftLimit) * (rightLimit - index);
            if (count <= k) {
                answer = answer * quickPower(value, count) % MODULO;
                k -= count;
            } else {
                answer = answer * quickPower(value, k) % MODULO;
                break;
            }
        }
        return (int) answer;
    }

    // Count the number of distinct prime factors of a given number
    private int countPrimeFactors(int number) {
        int factor = 2;
        Set<Integer> factors = new HashSet<>();
        while (factor <= number / factor) {
            while (number % factor == 0) {
                factors.add(factor);
                number /= factor;
            }
            ++factor;
        }
        if (number > 1) {
            factors.add(number);
        }
        return factors.size();
    }

    // Calculate a to the power of n modulo MODULO
    private int quickPower(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = result * base % MODULO;
            }
            base = base * base % MODULO;
            exponent >>= 1;
        }
        return (int) result;
    }
}
