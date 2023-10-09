/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(x, y) {
    let m=x.length;
    let n=y.length;
    let t=[];
    for(let i=0;i<m+1;i++){
        t.push([]);
    }
    
    for(let i=0;i<m+1;i++){
        for(let j=0;j<n+1;j++){
            if(i==0||j==0){
                t[i][j]=0;
            }
        }
    }

    for(let i=1;i<m+1;i++){
        for(let j=1;j<n+1;j++){
            if(x[i-1]==y[j-1]){
                t[i][j]=1+t[i-1][j-1];
            }
            else{
                t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
        }
    }
    return t[m][n];
};