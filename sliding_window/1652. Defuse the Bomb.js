/**
 * @param {number[]} code
 * @param {number} k
 * @return {number[]}
 */
var decrypt = function(code, k) {
    if(k>0){
        return caseOne(code,k);
    }
    return caseTwo(code,k);
};
function caseOne(arr,k){
    let sumOfK=0;
    for(let i=0;i<k;i++){
        sumOfK+=arr[i];
    }
    let res=[];
    for(let i=0;i<arr.length;i++){
        sumOfK-=arr[i];
        sumOfK+=arr[(i+k)%arr.length];
        res.push(sumOfK);
    }
    return res;
}
function caseTwo(arr,k){
    return caseOne(arr.reverse(),-k).reverse();
}