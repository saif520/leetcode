class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int j=0;
        int ans=0;
        while(i<nums.length){
            if(nums[i]==0){
                j=i+1;
            }
            i++;
            ans=Math.max(ans,i-j);
        } 
        return ans; 
    }
}