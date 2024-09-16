class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        int minutes[]=new int[n];
        for(int i=0;i<n;i++){
            int hours=Integer.parseInt(timePoints.get(i).substring(0,2));
            int min=Integer.parseInt(timePoints.get(i).substring(3,5));
            int totalMinutes=hours*60+min;
            minutes[i]=totalMinutes;
        }
        Arrays.sort(minutes);
        int minD=1440-(minutes[n-1]-minutes[0]);
        for(int i=0;i<n-1;i++){
            minD=Math.min(minD,minutes[i+1]-minutes[i]);
        }
        return minD;
    }
}