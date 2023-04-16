class Solution {
    public long[] findPrefixScore(int[] nums) {
        int len=nums.length;
        long[] ans=new long[len];
        long max=nums[0];
        
        for(int i=0;i<len;i++){
            long val=(long)nums[i];
            if(val>max){
                max=val;
            }
            ans[i]=val+max;
        }
        for(int i=1;i<len;i++){
            ans[i]+=ans[i-1];
        }
        return ans;
    }
}