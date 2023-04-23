class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int reachedTime=arrivalTime+delayedTime;
        if(reachedTime>=24){
            reachedTime=reachedTime-24;
        }
        return reachedTime;
    }
}