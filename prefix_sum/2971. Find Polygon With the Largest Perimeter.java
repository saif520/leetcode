class Solution {
    public long largestPerimeter(int[] arr) {
       Arrays.sort(arr);
       long[] nums = Arrays.stream(arr).mapToLong(i -> i).toArray();
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        long ans=0;
        for(int i=nums.length-1;i>=2;i--){
            long longestSide=nums[i]-nums[i-1];
            if(nums[i-1]>longestSide){
                ans=nums[i];
                return ans;
            }
        }
        return (long)-1;
    }
}