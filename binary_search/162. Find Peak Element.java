class Solution {
    public int findPeakElement(int[] A) {
        if(A.length==1){
            return 0;
        }
        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (mid - 1 < 0) {
                if (A[mid + 1] < A[mid]) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else if (mid + 1 >= A.length) {
                if (A[mid - 1] < A[mid]) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    return mid;
                }
                if (A[mid - 1] <= A[mid]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}