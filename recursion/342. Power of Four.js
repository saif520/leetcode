/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfFour = function(n) {
    if(n==1||n==4){
        return true;
    }
    if(n%4==1||n==0){
        return false;
    }
    return isPowerOfFour(n/4);
};