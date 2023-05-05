/**
 * @param {number} n
 * @return {number}
 */
var coloredCells = function(n) {
    let ans=1;
    let val=4;
    if(n==1){
        return ans;
    }
    for(let i=2;i<=n;i++){
        ans+=val;
        val=4*i;
    }
    return ans;
};