/**
 * @param {number[]} customers
 * @param {number[]} grumpy
 * @param {number} minutes
 * @return {number}
 */
var maxSatisfied = function(customers, grumpy, x) {
    var sum=0;
    for(let i=0;i<customers.length;i++){
        if(grumpy[i]===0){
            sum+=customers[i];
        }
    }
    var max=sum;
    for(let i=0;i<customers.length;i++){
        if(grumpy[i]===1){
            sum+=customers[i];
        }
        if(i<x-1){
            continue;
        }
        else if(i===x-1){
            max=Math.max(sum,max);
        }
        else{
            if(grumpy[i-x]===1){
                sum-=customers[i-x];
            }
            max=Math.max(sum,max);
        }
    }
    return max;
};