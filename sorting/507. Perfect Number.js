/**
 * @param {number} num
 * @return {boolean}
 */
var checkPerfectNumber = function(num) {
    if(num==0||num==1){
        return false;
    }
    let sum=0;
    for(var i=1;i<=Math.floor(num/2);i++){
        if(num%i==0){
            sum+=i;
        }
    }
    return sum==num;
};