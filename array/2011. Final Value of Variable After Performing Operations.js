/**
 * @param {string[]} operations
 * @return {number}
 */
var finalValueAfterOperations = function(operations) {
    let ans=0;
    for(let i=0;i<operations.length;i++){
        if(operations[i]=="--X"||operations[i]=="X--"){
            ans--;
        }
        else{
            ans++;
        }
    }
    return ans;
};