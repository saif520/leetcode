class Solution {
    public int countHillValley(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i+1<n;i++){
            if(nums[i]>nums[i+1]){
                arr.add(nums[i]);
            }
            else if(nums[i]<nums[i+1]){
                arr.add(nums[i]);
            }
            else{

            }
        }
        arr.add(nums[n-1]);
        int ans=0;
        for(int i=1;i+1<arr.size();i++){
            if(arr.get(i)>arr.get(i-1)&&arr.get(i)>arr.get(i+1)||arr.get(i)<arr.get(i-1)&&arr.get(i)<arr.get(i+1)){
                ans++;
            }
        }
        return ans;
    }
}