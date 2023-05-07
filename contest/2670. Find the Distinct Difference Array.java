class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int ans[]=new int[nums.length];
        HashSet<Integer>set1=new HashSet<>();
        HashSet<Integer>set2=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set1.add(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                set2.add(nums[j]);
            }
            ans[i]=set1.size()-set2.size();
            set2.clear();
        }
        return ans;
    }
}