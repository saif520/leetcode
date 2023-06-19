/**
 * @param {number[]} arr
 * @return {number}
 */
var sumOddLengthSubarrays = function(arr) {
    let res=0;
    for(let i=1;i<arr.length;i++){
        arr[i]+=arr[i-1];
    }

    for(let start=0;start<arr.length;start++){
        for(let end=start;end<arr.length;end+=2){
            res+=sumBetween(start,end);
        }
    }
    return res;

    function sumBetween(start,end){
        return arr[end]-(arr[start-1]||0);
    }
};