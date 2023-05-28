/**
 * @param {string} num
 * @return {string}
 */
var removeTrailingZeros = function(num) {
    let i=num.length-1;
    
    while(i>=0){
        if(num[i]==0){
            i--;
        }
        else{
            break;
        }
    }
    
    return num.slice(0,i+1);
};