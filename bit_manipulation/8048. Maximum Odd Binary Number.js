/**
 * @param {string} s
 * @return {string}
 */
var maximumOddBinaryNumber = function(s) {
    let countone=0;
    let countzero=0;
    s=s.split('');
    for(let i=0;i<s.length;i++){
        if(s[i]=='0'){
            countzero++;
        }
        else{
            countone++;
        }
    }
    let ans="";
    if(countone==1){
        while(countzero>0){
            ans+=0;
            countzero--;
        }
        ans+=1;
    }
    else{
        while(countone>1){
            ans+=1;
            countone--;
        }
        while(countzero>0){
            ans+=0;
            countzero--;
        }
        ans+=1;
    }
    return ans;
};