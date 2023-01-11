/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    x=x.toString().split('');
    console.log(x);

    for(let i=x.length-1;i>=0;i--){
        if(x[i]=="0"){
            x.pop();
        }
        else{
            break;
        }
    }
    if(x[0]=='-'){
        let left=1;
        let right=x.length-1;
        while(left<right){
            let temp=x[left];
            x[left]=x[right];
            x[right]=temp;
            left++;
            right--;
        }
    }
    else{
        let left=0;
        let right=x.length-1;
        while(left<right){
            let temp=x[left];
            x[left]=x[right];
            x[right]=temp;
            left++;
            right--;
        }
    }
    x=+x.join('');
    if(x>=2147483647||x<=-2147483648){
        return 0;
    }
    return x;
};