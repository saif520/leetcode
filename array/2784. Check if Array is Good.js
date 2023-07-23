/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isGood = function(nums) {
    let n=nums.length;
    let max=-Infinity;
    for(let i=0;i<nums.length;i++){
        if(nums[i]>max){
            max=nums[i];
        }
    }
    console.log(max);
    let countmax=0;
    for(let i=0;i<nums.length;i++){
        if(nums[i]==max){
            countmax++;
        }
    }
    if(max==n-1&&countmax==2){
        return true;
    }
    return false;
};