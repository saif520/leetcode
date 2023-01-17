/**
 * @param {string} num
 * @return {boolean}
 */
var digitCount = function(num) {
    num=num.split('');
//    num=num.sort();
    let n=num.length;
    let count=[0,0,0,0,0,0,0,0,0,0]
    for(let i=0;i<num.length;i++){
        if(num[i]=='0'){
            count[0]++;
        }
        else if(num[i]=='1'){
            count[1]++;
        }
         else if(num[i]=='2'){
            count[2]++;
        }
         else if(num[i]=='3'){
            count[3]++;
        }
         else if(num[i]=='4'){
            count[4]++;
        }
         else if(num[i]=='5'){
            count[5]++;
        }
         else if(num[i]=='6'){
            count[6]++;
        }
         else if(num[i]=='7'){
            count[7]++;
        }
         else if(num[i]=='8'){
            count[8]++;
        }
         else if(num[i]=='9'){
            count[9]++;
        }
    }
    count=count.toString().split(",");

    let flag=0;
    for(let i=0;i<num.length;i++){
        if(num[i]==count[i]){
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