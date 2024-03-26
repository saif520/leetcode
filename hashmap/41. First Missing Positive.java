class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans=0;
        for(int i=1;i<=100002;i++){
            if(set.contains(i)){
                continue;
            }
            else{
                return i;
            }
        }
        return 0;
    }
}