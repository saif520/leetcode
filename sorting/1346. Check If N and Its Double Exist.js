/**
 * @param {number[]} arr
 * @return {boolean}
 */
var checkIfExist = function(arr) {
    for(let i=0;i<arr.length-1;i++){
        for(let j=i+1;j<arr.length;j++){
            if(arr[i]==2*arr[j]||2*arr[i]==arr[j]){
                return true;
            }
        }
    }
    return false;
};