/**
 * @param {number[]} nums
 * @return {number}
 */
var findNumbers = function(nums) {
    nums.toString().split(",");

    let count=0;
    for(let i=0;i<nums.length;i++){
        let str=nums[i].toString();
        if(str.length%2==0){
            count++;
        }
    }
    return count;
};