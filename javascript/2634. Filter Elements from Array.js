/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    var ans=[];
    var L=arr.length;
    for(var i=0;i<L;i++){
        if(fn(arr[i],i)){
            ans.push(arr[i]);
        }
    }
    return ans;
};