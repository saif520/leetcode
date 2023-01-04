/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    nums=nums.sort();
    let count=1;
    for(let i=0;i<nums.length;i++){
        if(nums[i]==nums[i+1]){
            count++;
        }
        else{
            if(count==1){
                return nums[i];
            }
            count=1;
        }
    }
};