/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Initialize pointers for the range start and end.
        int start = 1;
        int end = n;
      
        // Continue searching while the range has more than one version.
        while (start < end) {
            // Calculate the middle version of the current range.
            // Using unsigned right shift operator to avoid integer overflow.
            int mid = start + (end - start) / 2;
          
            // Check if the middle version is bad.
            if (isBadVersion(mid)) {
                // If the middle version is bad, the first bad version 
                // is before it or it is the first bad version itself.
                end = mid;
            } else {
                // If the middle version is good, the first bad version
                // must be after it.
                start = mid + 1;
            }
        }
      
        // At this point, start == end and it is the first bad version.
        return start;
    }
}