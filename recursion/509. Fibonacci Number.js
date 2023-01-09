/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    if(n<=1){
        return n;
    }
    let lt=fib(n-1);
    let lst=fib(n-2);
    let ans=lt+lst;
    return ans;
};