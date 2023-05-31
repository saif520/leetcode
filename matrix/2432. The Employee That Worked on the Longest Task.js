/**
 * @param {number} n
 * @param {number[][]} logs
 * @return {number}
 */
var hardestWorker = function(n, logs) {
    let r=logs.length;
    let c=logs[0].length;
    let max=0;
    let id=0;
    let start=0;
    for(let i=0;i<r;i++){
    
        if(logs[i][1]-start>max){
            max=logs[i][1]-start;
            id=logs[i][0];
        }
        if(logs[i][1]-start==max){
            if(logs[i][0]<id){
                id=logs[i][0];
            }
        }
        start=logs[i][1];
    }
    return id;
};