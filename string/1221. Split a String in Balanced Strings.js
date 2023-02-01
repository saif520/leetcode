/**
 * @param {string} s
 * @return {number}
 */
var balancedStringSplit = function(s) {
    s=s.split('');
    let ans=0;
    let count=0;
    for(let i=0;i<s.length;i++){
        if(s[i]=='L'){
            count++;
        }
        if(s[i]=='R'){
            count--;
        }
        if(count==0){
            ans++;
        }
    }
    return ans;
};
