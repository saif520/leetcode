/**
 * @param {string} moves
 * @return {number}
 */
var furthestDistanceFromOrigin = function(moves) {
    let sum=0;
    let sum1=0;
    for(let i=0;i<moves.length;i++){
        if(moves[i]=='L'){
            sum=sum-1;
            sum1=sum1-1;
        }
        else if(moves[i]=='_'){
            sum=sum-1;
            sum1=sum1+1;
        }
        else{
            sum=sum+1;
            sum1=sum1+1;
        }
    }
    return Math.max(Math.abs(sum),Math.abs(sum1));
};