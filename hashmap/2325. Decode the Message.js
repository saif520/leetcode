/**
 * @param {string} key
 * @param {string} message
 * @return {string}
 */
var decodeMessage = function(key, message) {
    let str="abcdefghijklmnopqrstuvwxyz".split('');
    let obj={};
    key=key.split('');
    let j=0;
    for(let i=0;i<key.length;i++){
        if(obj[key[i]]){
            obj[key[i]]++;
        }
        else{
            obj[key[i]]=1;
        }
        
    }
    let s="";
    for(let i in obj){
        if(i!=' '){
            s+=i;
        }
    }
    
    s=s.split('');
    let map={};
    for(let i=0;i<s.length;i++){
        map[s[i]]=str[i];
    }
    
    message=message.split('');
    
    let ans="";
    
    for(let i=0;i<message.length;i++){
        if(message[i]==' '){
            ans+=message[i];
        }
        else{
            ans+=map[message[i]];
        }
    }
    
    return ans;
};

