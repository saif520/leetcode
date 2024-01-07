class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int prefixSum=nums[0];
        
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                prefixSum+=nums[i];
            }
            else{
                break;
            }
        }
        
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++){
            if(nums[i]==prefixSum){
                prefixSum++;
            }
        }
        return prefixSum;
    }
}