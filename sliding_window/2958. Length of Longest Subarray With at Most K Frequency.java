class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int left=0;
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.get(nums[right])==null?1:map.get(nums[right])+1);
            while(map.get(nums[right])>k&&right<nums.length){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}