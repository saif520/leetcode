/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfThree = function(n) {
    if(n==1||n==3){
        return true;
    }
    if(n%3==1||n==0){
        return false;
    }
    return isPowerOfThree(n/3);
};