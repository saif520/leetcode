/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    x=x.toString();
    x=x.split('');
    x=x.map(Number);
    let left=0;
    let right=x.length-1;
    while(left<right){
        if(x[left]!=x[right]){
            return false;
        }
        left++;
        right--;
    }
    return true;
};