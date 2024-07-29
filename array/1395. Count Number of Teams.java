class Solution {
    public int numTeams(int[] rating) {
        int n=rating.length;
        int totalTeam=0;
        for(int i=0;i<n;i++){
            int lessLeft=0;
            int lessRight=0;
            int greaterLeft=0;
            int greaterRight=0;
            for(int j=0;j<i;j++){
                if(rating[j]<rating[i]){
                    lessLeft++;
                }
                else if(rating[j]>rating[i]){
                    greaterLeft++;
                }
            }
            for(int j=i+1;j<n;j++){
                if(rating[j]<rating[i]){
                    lessRight++;
                }
                else if(rating[j]>rating[i]){
                    greaterRight++;
                }
            }
            totalTeam+=lessLeft*greaterRight+greaterLeft*lessRight;
        }

        return totalTeam;
    }
}