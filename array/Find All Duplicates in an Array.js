/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function(nums) {
    nums=nums.sort();
    let count=1;
    let bag=[];
    for(let i=0;i<nums.length;i++){
        if(nums[i]==nums[i+1]){
            count++;
        }
        else{
            if(count>=2){
                bag.push(nums[i]);
            }
            count=1;
        }
    }
    bag=bag;
    return bag;
};