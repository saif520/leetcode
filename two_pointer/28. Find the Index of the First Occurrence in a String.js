/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(stack, needle) {
    stack=stack.split('');
    needle=needle.split('');
    let slen=stack.length;
    let nlen=needle.length;
    let count=0;
    for(let i=0;i<=slen-nlen;i++){
        let j=i;
        let k=0;
        while(k<nlen){
            if(stack[j]==needle[k]){
                j++;
                k++;
                count++;
                console.log(count);
            }
            else{
                count=0;
                break;
            }
        }
        if(count==nlen){
            return i;
        }
    }
    return -1;
};