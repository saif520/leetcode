class Solution {
    private int getMaxDigit(int num){
        int maxD=0;
        while(num>0){
            maxD=Math.max(maxD,num%10);
            num/=10;
        }
        return maxD;
    }
    public int maxSum(int[] nums) {
        int ans=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(getMaxDigit(nums[i])==getMaxDigit(nums[j])){
                    ans=Math.max(ans,nums[i]+nums[j]);
                }
            }
        }
        return ans;
    }
}