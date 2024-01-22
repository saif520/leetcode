class Solution {
    public int[] findErrorNums(int[] nums) {
        int ans[]=new int[2];
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.get(nums[i])==null?1:map.get(nums[i])+1);
        }
        int repeat=0;
        for(int i=0;i<nums.length;i++){
            if((int)map.get(nums[i])==2){
                repeat=nums[i];
            }
        }

        int missing=0;
        for(int i=1;i<=nums.length;i++){
            if(map.containsKey(i)){
                continue;
            }
            else{
                missing=i;
                break;
            }
        }
        ans[0]=repeat;
        ans[1]=missing;
        return ans;
    }
}