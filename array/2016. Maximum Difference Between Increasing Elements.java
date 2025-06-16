class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        # Initialize the minimum value seen so far to infinity
        min_val = float('inf')
        # Initialize the maximum difference as -1 (default if not found)
        max_diff = -1
      
        # Iterate over each number in the list
        for num in nums:
            # If the current number is greater than the minimum value seen,
            # there is a potential for a new maximum difference
            if num > min_val:
                # Update the maximum difference if the current difference
                # is greater than the previous maximum difference
                max_diff = max(max_diff, num - min_val)
            else:
                # If the current number is not greater than the minimum value seen,
                # update the minimum value to the current number
                min_val = num
      
        # Return the maximum difference found; if no valid difference was found,
        # this will return -1
        return max_diff