/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var canBeEqual = function(s1, s2) {
    s1=s1.split('');
    s2=s2.split('');
    if(comp(s1,s2)==true){
        return true;
    }
    let temp1=s1[0];
    let temp2=s1[2];
    
    s1[0]=temp2;
    s1[2]=temp1;
    if(comp(s1,s2)==true){
        return true;
    }
    let temp3=s1[1];
    let temp4=s1[3];
    s1[1]=temp4;
    s1[3]=temp3;
    if(comp(s1,s2)==true){
        return true;
    }
    return false;
};
let comp=function(s1,s2){
    for(let i=0;i<s1.length;i++){
        if(s1[i]==s2[i]){
            continue;
        }
        else{
            return false;
        }
    }
    return true;
}