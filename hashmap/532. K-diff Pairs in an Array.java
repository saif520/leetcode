class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
        if(k<0)
            return 0;
            
        for(int i=0;i<nums.length;i++) {
            mp.put(nums[i],i);
        }
        
        int cnt=0;
        for(int i=0;i<nums.length;i++) {
            if(mp.containsKey(k+nums[i]) && mp.get(k+nums[i])!=i) {
                cnt++;
                mp.remove(k+nums[i]);
            }
        }
        return cnt;
    }
}