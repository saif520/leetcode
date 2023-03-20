class Solution {
    public int maxScore(int[] arr) {
        long[] nums=new long[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i]=arr[i];
        }
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left<right){
            long temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];
        }
        
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result++;
            }
        }
        return result;
    }
}