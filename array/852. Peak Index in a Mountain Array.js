/**
 * @param {number[]} arr
 * @return {number}
 */
var peakIndexInMountainArray = function(arr) {
    let idx=1;
    let max=0;
    for(let i=1;i<arr.length-1;i++){
        let val;
        if(arr[i-1]<arr[i]&&arr[i]>arr[i+1]){
            idx=i;
            val=arr[i];
        }
        if(val>max){
            max=val;
            idx=i;
        }
    }
    return idx;
};