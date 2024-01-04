class Solution {
    public int minOperations(int[] nums) {
        int count=nums.length;
        int ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.get(nums[i])==null?1:map.get(nums[i])+1);
        }
        for(Map.Entry e:map.entrySet()){
            int val=(int)e.getValue();
            if(val==1){
                return -1;
            }
            while(val>=2){
                if(val%2!=0&&val%3!=0){
                    val-=3;
                    ans++;
                }
                else if(val%2==0&&val%3==0){
                    val-=3;
                    ans++;
                }
                else if(val%3==0){
                    val-=3;
                    ans++;
                }
                else if(val%2==0){
                    val-=2;
                    ans++;
                }
            }
        }
        return ans;
    }
}