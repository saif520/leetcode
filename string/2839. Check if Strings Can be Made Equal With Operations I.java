class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length==1){
            return true;
        }
        boolean flag=true;
        for(int i=0,j=1;i<nums.length&&j<nums.length;i++,j++){
            if((nums[i]%2==0&&nums[j]%2!=0)||(nums[i]%2!=0&&nums[j]%2==0)){
                flag=true; 
            }
            else{
                flag=false;
                break;
            }
        }
        return flag;
    }
}