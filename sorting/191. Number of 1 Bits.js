/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count=0;
    while(n>=0){
        if(n==0){
            break;
        }
        let r=n%2;
        if(r==1){
            count++;
        }
        n=Math.floor(n/2);
    }
    return count;
};