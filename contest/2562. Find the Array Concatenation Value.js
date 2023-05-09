/**
 * @param {number[]} nums
 * @return {number}
 */
var findTheArrayConcVal = function(nums) {
    let i=0;
    let j=nums.length-1;
    let sum=0;
    while(i<=j){
        if(i==j){
            sum+=nums[i];
            break;
        }
        let a=nums[i].toString();
        let b=nums[j].toString();
        let c=a+b;
        c=Number(c);
        console.log(c);
        sum+=c;
        i++;
        j--;
    }
    return sum;  
};