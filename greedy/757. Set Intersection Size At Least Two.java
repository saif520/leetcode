class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        // Sort by end ascending, and if tie, by start descending
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        List<Integer> chosen = new ArrayList<>();

        int a = -1, b = -1;  // two largest chosen numbers

        for (int[] I : intervals) {
            int l = I[0], r = I[1];

            boolean aIn = (a >= l);
            boolean bIn = (b >= l);

            if (aIn && bIn) {
                continue;               // interval already has ≥2 points
            } else if (bIn) {           // only one point in interval
                a = b;
                b = r;                  // add r
                chosen.add(r);
            } else {
                // add two points: r-1 and r
                a = r - 1;
                b = r;
                chosen.add(r - 1);
                chosen.add(r);
            }
        }

        return chosen.size();
    }
}
