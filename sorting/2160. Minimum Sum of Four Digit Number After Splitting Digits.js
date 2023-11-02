/**
 * @param {number} num
 * @return {number}
 */
var minimumSum = function(num) {
    num=num.toString().split('');
    num=num.sort(function(a,b){
        return a-b;
    })
    console.log(num);
    let num1=num[0]+num[2];
    let num2=num[1]+num[3];
    return Number(num1)+Number(num2);
};