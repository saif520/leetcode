/**
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(words) {
    let ans=[];
    for(let i=0;i<words.length;i++){
        if(check(words[i])==true){
            ans.push(words[i]);
        }
    }
    return ans;
};
function check(str){
        str=str.toLowerCase().split('');
        let line1="qwertyuiop".split('');
        let line2="asdfghjkl".split('');
        let line3="zxcvbnm".split('');
        let flag1;
        let flag2;
        let flag3;

        for(let i=0;i<str.length;i++){
            flag1=0;
            for(let j=0;j<line1.length;j++){
                if(str[i]==line1[j]){
                    flag1=1;
                    break;
                }
            }
            if(flag1==0){
                break;
            }
        } 
        if(flag1==1){
            return true;
        }
        for(let i=0;i<str.length;i++){
            flag2=0;
            for(let j=0;j<line2.length;j++){
                if(str[i]==line2[j]){
                    flag2=1;
                    break;
                }
            }
            if(flag2==0){
                break;
            }
        } 
        if(flag2==1){
            return true;
        }

        for(let i=0;i<str.length;i++){
            flag3=0;
            for(let j=0;j<line3.length;j++){
                if(str[i]==line3[j]){
                    flag3=1;
                    break;
                }
            }
            if(flag3==0){
                break;
            }
        } 
        if(flag3==1){
            return true;
        }
}