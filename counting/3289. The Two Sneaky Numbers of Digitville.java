class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int ans[]=new int[2];
        int arr[]=new int[100];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        int k=0;
        for(int i=0;i<100;i++){
            if(arr[i]==2){
                ans[k++]=i;
            }
        }
        return ans;
    }
}