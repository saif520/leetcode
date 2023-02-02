/**
 * @param {number[]} nums
 * @return {number[]}
 */
var singleNumber = function(nums) {
    let obj={};
    for(let i=0;i<nums.length;i++){
        if(obj[nums[i]]){
            obj[nums[i]]++;
        }
        else{
            obj[nums[i]]=1;
        }
    }
    let ans=[];
    for(let i in obj){
        if(obj[i]==1){
            ans.push(i);
        }
    }
    return ans;
};