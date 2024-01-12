class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        for(int i=k-1;i<nums.length;i++){
            int minDiff=nums[i]-nums[i-k+1];
            if(minDiff<min){
                min=minDiff;
            }
        }
        return min;
    }
}