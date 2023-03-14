class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] pref = new  int[1005];

		for(int[] trip: trips){
			int numPeople = trip[0];
			int sp = trip[1];
			int ep= trip[2];

			pref[sp] += numPeople;
			pref[ep] -= numPeople;
		}
		
		for(int i = 1;i<1005;i++){
			pref[i] += pref[i-1];
		}

		// check if trips are possible
		for(int i = 0;i<1005;i++){
			if(pref[i] > capacity) return false;
		}
		return true;
    }
}