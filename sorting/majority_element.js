/**
 * @param {number[]} nums
 * @return {number}
 */
 var majorityElement = function(nums) {
    /*
    nums=nums.sort();
    console.log(nums);
    let n=nums.length;
    let left=0;
    let right=n-1;
    let count=1;
    let max=0;
    let m;
    let mid=Math.floor((left+right)/2);
    for(let i=0;i<n;i++){
        if(nums[i]==nums[i+1]){
            count++;
        }
        else{
            if(count>max){
                max=count;
                m=nums[i];
            }
            count=1;
        }
    }
    return m;
    */
    
    let n=nums.length;
    let majority=nums[0];
    let count=1;
    for(let i=1;i<n;i++){
        if(nums[i]==majority){
            count++;
        }
        else{
            count--;
            if(count==0){
                majority=nums[i];
                count=1;
            }
        }
    }
    return majority;
};