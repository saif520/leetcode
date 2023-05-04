/**
 * @param {number} n
 * @param {number} time
 * @return {number}
 */
var passThePillow = function(n, time) {
    let i=1;
    while(time>0){
        while(i<n&&time>0){
            i++;time--;
        }
        while(i>1&&time>0){
            i--;time--;
        }
    }
    return i;
};