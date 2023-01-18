/**
 * @param {number} n
 * @return {boolean}
 */
var hasAlternatingBits = function(n) {
    if(n==1){
        return true;
    }
    let bag=[];
    while(n>=0){
        if(n==0){
            break;
        }
        let r=n%2;
        bag.push(r);
        n=Math.floor(n/2);
    }

    let left=0;
    let right=bag.length-1;
    while(left<right){
        let temp=bag[left];
        bag[left]=bag[right];
        bag[right]=temp;
        left++;
        right--;
    }
    console.log(bag);
    let flag=0;
    for(let i=0,j=1;i<bag.length-1;i++,j++){
        flag=0;
        if(bag[i]!=bag[j]){
            flag=1;
        }
        else{
            return false;
        }
    }
    if(flag==1){
        return true;
    }
};