/**
 * @param {string} s
 * @return {boolean}
 */
var halvesAreAlike = function(s) {
    s=s.split('');
    let mid=Math.floor(s.length/2);
    let vowel='aeiouAEIOU';
    let count=0;
    for(let i=0;i<s.length;i++){
        for(let j=0;j<vowel.length;j++){
            if(s[i]==vowel[j]){
                if(i<mid){
                    count++;
                }
                else{
                    count--;
                }
            }
        }
    }
    if(count==0){
        return true;
    }
    else{
        return false;
    }
};