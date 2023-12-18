/**
 * @param {number} num
 * @return {boolean}
 */
var isSameAfterReversals = function(num) {
    let last=num%10;
    
    let count=0;
    while(num!=0){
        let rem=num%10;
        num=Math.floor(num/10);
        count++;
    }
    
    if(count==0||count==1){
        return true;
    }
    if(last!=0){
        return true;
    }
    return false;
};