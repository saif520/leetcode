class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double max=Integer.MIN_VALUE;
        if(sum/k>max){
            max=sum/(double)k;
        }
        for(int i=k;i<nums.length;i++){
            sum=sum+nums[i]-nums[i-k];
            if(sum/(double)k>max){
                max=sum/(double)k;
            }
        }
        return max;
    }
}