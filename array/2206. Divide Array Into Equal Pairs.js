/**
 * @param {number[]} nums
 * @return {boolean}
 */
var divideArray = function(nums) {
    let obj={};
    for(let i=0;i<nums.length;i++){
        if(obj[nums[i]]){
            obj[nums[i]]++;
        }
        else{
            obj[nums[i]]=1;
        }
    }
    console.log(obj);
    for(let i in obj){
        if(obj[i]%2!=0){
            return false;
        }
    }
    return true;
};