/**
 * @param {number} num
 * @return {number}
 */
var countDigits = function(num) {
    let number=num;
    let count=0;
    while(num>0){
        let rem=num%10;
        if(number%rem==0){
            count++;
        }
        num=Math.floor(num/10);
    }
    return count;
};