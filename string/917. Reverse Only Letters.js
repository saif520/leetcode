/**
 * @param {string} s
 * @return {string}
 */
var reverseOnlyLetters = function(s) {
    s=s.split('');
    let left=0;
    let right=s.length-1;
    while(left<right){
        if(isChar(s[left])){
            while(!isChar(s[right])){
                right--;
            }
            let temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            right--;
        }
        left++;
    }
    return s.join('');
};

function isChar(ch){
    let str1="ABCDEFGHIJKLMNOPQRSTUVWXYZ".split('');
    let str2="abcdefghijklmnopqrstuvwxyz".split('');

    for(let i=0;i<str1.length;i++){
        if(ch==str1[i]||ch==str2[i]){
            return true;
        }
    }
}