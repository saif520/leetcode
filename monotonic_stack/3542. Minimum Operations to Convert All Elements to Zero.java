import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int n : nums) {
            // Pop larger previous elements
            while (!stack.isEmpty() && stack.peek() > n) {
                stack.pop();
            }

            if (n > 0 && (stack.isEmpty() || n > stack.peek())) {
                res++;
                stack.push(n);
            }
        }

        return res;
    }
}
