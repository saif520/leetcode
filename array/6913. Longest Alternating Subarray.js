/**
 * @param {number[]} nums
 * @return {number}
 */
var alternatingSubarray = function(nums) {
    let max=-1;
    let bag=[];
    for(let i=0;i<nums.length;i++){
        bag=[];
        for(let j=i;j<nums.length;j++){
            bag.push(nums[j]);
            // console.log(bag);
            if(bag.length>1){
                if(check(bag)==true){
                    if(bag.length>max){
                        max=bag.length;
                    }
                }
            }
        }
    }
    return max;
};
let check=function(bag){
    let flag=false;
    for(let i=1;i<bag.length;i++){
        if(i%2==1&&(bag[i]-bag[i-1])==1){
            flag=true;
        }
        else if(i%2==0&&(bag[i]-bag[i-1])==-1){
            flag=true;
        }
        else{
            return false;
        }
    }
    return true;
}