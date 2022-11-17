/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
 var searchMatrix = function(matrix, target) {
    let m=matrix.length;
    let n=matrix[0].length;
    let r=0;
    let c=n-1;
    while(r<m&&c>=0){
        if(matrix[r][c]==target)
            return true;
        else if(matrix[r][c]<target)
            r++;
        else
            c--
    }
    return false;
};