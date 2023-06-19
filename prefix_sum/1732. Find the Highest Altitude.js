/**
 * @param {number[]} gain
 * @return {number}
 */
var largestAltitude = function(gain) {
    let max=0;
    if(gain[0]>max){
        max=gain[0];
    }
    for(let i=1;i<gain.length;i++){
        gain[i]=gain[i]+gain[i-1];
        if(gain[i]>max){
            max=gain[i];
        }
    }
    console.log(gain);
    return max;
};