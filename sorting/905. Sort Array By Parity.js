/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParity = function(nums) {
    let arr=[];
    for(let i=0;i<nums.length;i++){
        if(nums[i]%2==0){
            arr.push(nums[i]);
        }
    }
    for(let i=0;i<nums.length;i++){
        if(nums[i]%2!=0){
            arr.push(nums[i]);
        }
    }
    return arr;
};