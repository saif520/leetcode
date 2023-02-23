/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isMonotonic = function(nums) {
    let n=nums.length;
    let flag1=0;
    let flag2=0;
    for(let i=0,j=1;i<n-1;i++,j++){
        if(nums[i]<=nums[j]){
            flag1=1;
        }
        else{
            flag1=0;
            break;
        }
    }
    if(flag1==1){
        return true;
    }
    else{
        for(let i=0,j=1;i<n-1;i++,j++){
            if(nums[i]>=nums[j]){
                flag2=1;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
  