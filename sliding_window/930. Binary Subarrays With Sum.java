class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    public static int atmost(int[]nums,int k){
        int sum=0;
        int end=0,start=0,count=0;
        while(end<nums.length){
            sum+=nums[end++];
            while(start<end&&sum>k){
                sum-=nums[start++];
            }
            count+=end-start;
        }
        return count;
    }
}