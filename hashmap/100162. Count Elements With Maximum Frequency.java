class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.get(nums[i])==null?1:map.get(nums[i])+1);
        }
        
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])>max){
                max=map.get(nums[i]);
            }
        }
        
        int total=0;
        for(Map.Entry e:map.entrySet()){
            if((int)e.getValue()==max){
                total+=max;
            }
        }
        return total;
    }
}