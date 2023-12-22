/**
 * @param {string} s
 * @return {number}
 */
var maxScore = function(s) {
    s=s.split('');
    let n=s.length;

    let zerosum=0;
    let onesum=0;
    for(let i=n-1;i>0;i--){
        if(s[i]==1){
            onesum+=1;
        }  
    }
    let max=-Infinity;
    let left=0;
    let right=1;
    while(right<n){
        if(s[left]==0){
            zerosum+=1;
        }
        if(zerosum+onesum>max){
            max=zerosum+onesum;
        }
        if(s[right]==1){
            onesum-=1;
        }
        left++;
        right++;
    }
    return max;
};