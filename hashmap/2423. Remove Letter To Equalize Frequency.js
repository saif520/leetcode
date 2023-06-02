/**
 * @param {string} word
 * @return {boolean}
 */
var equalFrequency = function(word) {
    let obj={};
    for(let i=0;i<word.length;i++){
        if(obj[word[i]]){
            obj[word[i]]++;
        }
        else{
            obj[word[i]]=1;
        }
    }
    let arr=[];
    for(let i in obj){
        arr.push(obj[i]);
    }
    arr=arr.sort(function(a,b){
        return a-b;
    })
    console.log(arr);
    if(arr.length==1){
        return true;
    }
    let flag1=0;
    for(let i=0;i<arr.length-1;i++){
        if(arr[i]==1&&arr[i]==arr[i+1]){
            flag1=1;
        }
        else{
            flag1=0;
            break;
        }
    }
    if(flag1==1){
        return true; 
    }
    if(arr.length==2){
        if(arr[0]==1||arr[arr.length-1]==1){
            return true;
        }
        if(Math.abs(arr[0]-arr[1])==1){
            return true;
        }
        else{
            return false;
        }
    }
    console.log(arr);
    let f1=0;
    if(arr[0]==1){
        for(let i=1;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                f1=1;
            }
            else{
                f1=0;
                break;
            }
        }
    }
    
    if(f1==1){
        return true;
    }
    let f2=0;
    if(arr[arr.length-1]==1||arr[arr.length-1]-arr[arr.length-2]==1){
        for(let i=0;i<arr.length-2;i++){
            if(arr[i]==arr[i+1]){
                f2=1;
            }
            else{
                f2=0;
                break;
            }
        }
    }
    if(f2==1){
        return true;
    }
    return false;
    
};