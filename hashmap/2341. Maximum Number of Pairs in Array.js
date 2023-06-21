/**
 * @param {number[]} nums
 * @return {number[]}
 */
var numberOfPairs = function(nums) {
    let obj={};
    for(let i=0;i<nums.length;i++){
        if(obj[nums[i]]){
            obj[nums[i]]++;
        }
        else{
            obj[nums[i]]=1;
        }
    }
    let count=0;
    for(let i in obj){
        while(obj[i]>=2){
            obj[i]=obj[i]-2;
            count++;
        }
    }
    
    let leftover=0;
    for(let i in obj){
        if(obj[i]==1){
            leftover++;
        }
    }
    
    return [count,leftover]
};