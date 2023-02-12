class Solution {
    public boolean canBeIncreasing(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        for(int i=0;i<arr.size();i++){
            int temp=arr.remove(i);
            boolean x=check(arr);
            if(x==true){
                return true;
            }
            else{
                check(arr);
            }
            arr.add(i,temp);
        }
        return false;
    }
    public boolean check(ArrayList<Integer>arr){
        int flag=0;
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i)<arr.get(i+1)){
                flag=1;
            }
            else{
                return false;
            }
        }
       return true;
    }
}