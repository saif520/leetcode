/**
 * @param {number[]} nums
 * @return {number}
 */
var countDistinctIntegers = function(nums) {
    let len=nums.length;
    for(let i=0;i<len;i++){
        nums.push(reverse(nums[i]));
    }     
    let obj={};
    for(let i=0;i<nums.length;i++){
        if(obj[nums[i]]){
            obj[nums[i]]++;
        }
        else{
            obj[nums[i]]=1;
        }
    }
    return Object.keys(obj).length;
};
function reverse(n){
    let rev=0;
    while(n>0){
        rev=rev*10+n%10;
        n=Math.floor(n/10);
    }
    return rev;
}