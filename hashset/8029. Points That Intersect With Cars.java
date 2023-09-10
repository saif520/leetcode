class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.size();i++){
            int start=nums.get(i).get(0);
            int end=nums.get(i).get(1);
            while(start<=end){
                set.add(start);
                start++;
            }
        }
        return set.size();
    }
}
