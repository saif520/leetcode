class Solution {
    public int maximumCount(int[] nums) {
        int pcount=0;
        int ncount=0;
        for(int num:nums){
            if(num<0){
                ncount++;
            }
            else if(num>0){
                pcount++;
            }
        }
        return Math.max(ncount,pcount);
    }
}