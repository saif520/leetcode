class Solution {
    public int subarraySum(int[] nums, int k) {
        int result=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int runningSum=0;
        for(int num : nums){
            runningSum+=num;

            int x=runningSum;
            int y=runningSum-k;
            if(map.containsKey(y)==true){
                result+=map.get(y);
            }
            map.put(runningSum, map.getOrDefault(runningSum,0)+1);
        }
        return result;
    }
}