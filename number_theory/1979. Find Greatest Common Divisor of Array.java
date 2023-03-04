class Solution {
    public int findGCD(int[] nums) {
        int min=1001, max=0;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int ans=1;
        for(int i=1;i<=min;i++){
            if(min%i==0&&max%i==0){
                ans=i;
            }
        }
        return ans;
    }
}