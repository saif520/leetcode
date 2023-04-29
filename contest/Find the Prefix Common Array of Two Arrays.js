/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number[]}
 */
var findThePrefixCommonArray = function(A, B) {
    let C=[];
    for(let i=0;i<A.length;i++){
        let count=checkCommon(i,A,B);
        C[i]=count;
    }
    return C;
};
let checkCommon=function(idx,A,B){
    let count=0;
    let obj={};
    for(let i=0;i<=idx;i++){
        obj[A[i]]=i;
    }
    for(let j=0;j<=idx;j++){
        if(B[j] in obj){
            count++;
        }
    }
    return count;
}