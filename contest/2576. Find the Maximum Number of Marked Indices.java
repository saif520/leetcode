class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        int j=(n+1)/2;
        int count=0;
        while(j<n){
            if(2*nums[i]<=nums[j]){
                i++;
                count+=2;
            }
            j++;
        }
        return count;
    }
}