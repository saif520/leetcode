/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    let numArr=[1000,900,500,400,100,90,50,40,10,9,5,4,1];
    let romArr=["M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"];
    let ans=[];
    for(let i=0;i<numArr.length;i++){
        while(num>=numArr[i]){
            ans.push(romArr[i]);
            num-=numArr[i];
        }
    }
    return ans.join('');
};