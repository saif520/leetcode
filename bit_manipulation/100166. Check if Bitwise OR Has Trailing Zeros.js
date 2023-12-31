/**
 * @param {number[]} nums
 * @return {boolean}
 */
var hasTrailingZeros = function(nums) {
    for(let i=0;i<nums.length;i++){
        for(let j=i+1;j<nums.length;j++){
            if((nums[i]|nums[j])%2==0){
                return true;
            }
        }
    }
    return false;
};