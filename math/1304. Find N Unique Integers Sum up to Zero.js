/**
 * @param {number} n
 * @return {number[]}
 */
var sumZero = function(n) {
    let ans=[];
    if(n%2!=0){
        ans.push(0);
        n--;
    }
    let x=1;
    for(let i=0;i<n;i+=2){
        ans.push(x);
        ans.push(-1*x);
        x++;
    }
    return ans;
};