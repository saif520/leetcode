/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
    let n=nums.length;
    let bag=[];
    for(let i=1;i<=n;i++){
        bag.push(i);
    }
    let temp=[];
    for(let i=0;i<bag.length;i++){
        let flag=0;
        for(let j=0;j<nums.length;j++){
            if(bag[i]==nums[j]){
                flag=1;
                break;
            }
        }
        if(flag==0){
            temp.push(bag[i]);
        }
    }
    return temp;
};