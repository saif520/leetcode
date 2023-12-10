/**
 * @param {number[]} batteryPercentages
 * @return {number}
 */
var countTestedDevices = function(bp) {
    let n=bp.length;
    let count=0;
    for(let i=0;i<n;i++){
        if(bp[i]>0){
            count++;
            for(let j=i+1;j<n;j++){
                bp[j]=Math.max(0,bp[j]-1);
            }
        }
        
    }
    return count;
};