class Solution {
    public int numRabbits(int[] answers) {
        // answers, reportess
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int answer : answers) {
            fmap.put(answer, fmap.getOrDefault(answer, 0) + 1);
        }

        int confirmedRabbitsInForest = 0;
        for (int key : fmap.keySet()) {
            int gs = key + 1;
            int reportess = fmap.get(key);

            int fullOccupiedGroups = reportess / gs;
            int partiallyOccupiedGroup = (reportess % gs) != 0 ? 1 : 0;

            int numberOfGroups = fullOccupiedGroups + partiallyOccupiedGroup;

            int numberOfRabbits = numberOfGroups * gs;

            confirmedRabbitsInForest += numberOfRabbits;
        }

        return confirmedRabbitsInForest;
    }
}