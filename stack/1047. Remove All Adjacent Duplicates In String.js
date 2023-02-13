/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicates = function(s) {
    s=s.split('');
    let ans=[];
    ans.push(s[0]);
    for(let i=1;i<s.length;i++){
        if(ans[ans.length-1]==s[i]){
            ans.pop();
        }
        else{
            ans.push(s[i]);
        }
    }
    return ans.join('');
};