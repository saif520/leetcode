/**
 * @param {string} s
 * @return {boolean}
 */
var checkString = function(s) {
    if(s.length==1){
        return true;
    }
    let temp=[];
    for(let i=0;i<s.length;i++){
        if(s[i]=='a'){
            temp.push(s[i]);
        }
        else{
            temp.push(s[i]);
        }
    }
    let flag=0;
    for(let i=0;i<temp.length-1;i++){
        if(temp[i]<=temp[i+1]){
            flag=1;
        }
        else{
            flag=0;
            break;
        }
    }
    if(flag==1){
        return true;
    }
    else{
        return false;
    }
};