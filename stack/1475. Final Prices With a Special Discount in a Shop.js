/**
 * @param {number[]} prices
 * @return {number[]}
 */
var finalPrices = function(prices) {
    let nextsmaller=[];
    let ans=[];
    let stack=[];
    for(let i=prices.length-1;i>=0;i--){
        while(stack.length>0&&prices[i]<stack[stack.length-1]){
            stack.pop();
        }
        let temp=stack.length>0?stack[stack.length-1]:-1;
        ans[i]=temp==-1?prices[i]-0:prices[i]-temp;
        stack.push(prices[i]);
    }
    return ans;
};