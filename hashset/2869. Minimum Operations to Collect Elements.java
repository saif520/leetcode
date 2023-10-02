class Solution {
    public int minOperations(List<Integer> nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=k;i++){
            set.add(i);
        }
        int count=0;
        for(int i=nums.size()-1;i>=0;i--){
            count++;
            if(set.contains(nums.get(i))){
                set.remove(nums.get(i));
            }
            if(set.size()==0){
                break;
            }
        }
        return count;
    }
}