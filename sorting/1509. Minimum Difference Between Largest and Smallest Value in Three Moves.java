class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        if(n<=3){
            return 0;
        }
        for(int i=1;i<=4;i++){
            min=Math.min(min,Math.abs(nums[n-i]-nums[4-i]));
        }
        return min;
    }
}