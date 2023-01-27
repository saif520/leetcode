/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParityII = function(nums) {
    let even=[];
    let odd=[];
    for(let i=0;i<nums.length;i++){
        if(nums[i]%2==0){
            even.push(nums[i]);
        }
        else{
            odd.push(nums[i]);
        }
    }
    let ans=[];
    for(let i=0,j=0;i<odd.length&&j<odd.length;i++,j++){
        ans.push(even[i]);
        ans.push(odd[j]);
    }
    return ans;
};