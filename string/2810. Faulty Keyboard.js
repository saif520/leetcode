/**
 * @param {string} s
 * @return {string}
 */
var finalString = function(s) {
    s=s.split('');
    let ans="";
    for(let i=0;i<s.length;i++){
        if(s[i]=='i'){
            let rev=reverseFun(ans);
            ans=rev;
        }
        else{
            ans+=s[i];
        }
    }
    
    return ans;
};
let reverseFun=function(ans){
    ans=ans.split('');
    let i=0;
    let j=ans.length-1;
    while(i<j){
        let temp=ans[i];
        ans[i]=ans[j];
        ans[j]=temp;
        i++;
        j--;
    }
    ans=ans.join('');
    return ans;
}