class Solution {
    public int[] getConcatenation(int[] nums) {
        int ans[]=new int[2*nums.length];
        for(int i=0,j=nums.length;i<nums.length&&j<2*nums.length;i++,j++){
            ans[i]=nums[i];
            ans[j]=nums[i];
        }
        return ans;
    }
}