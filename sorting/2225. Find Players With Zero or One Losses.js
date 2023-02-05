/**
 * @param {number[][]} matches
 * @return {number[][]}
 */
var findWinners = function(matches) {
    let win=[];
    for(let i=0;i<matches.length;i++){
        win.push(matches[i][0]);
    }
    let lose=[];
    for(let i=0;i<matches.length;i++){
        lose.push(matches[i][1]);
    }
    let obj={};
    for(let i=0;i<lose.length;i++){
        if(obj[lose[i]]){
            obj[lose[i]]++;
        }
        else{
            obj[lose[i]]=1;
        }
    }
    let oneLoser=[];
    for(let i in obj){
        if(obj[i]==1){
            oneLoser.push(i);
        }
    }
    //console.log(oneLoser);
   // mergeSort(oneLoser,0,oneLoser.length-1);
    let noLoser=[];
    for(let i=0;i<win.length;i++){
        if(!(win[i] in obj)){
            noLoser.push(win[i]);
        }
    }
    mergeSort(noLoser,0,noLoser.length-1);
    let NL=[]
    for(let i=0;i<noLoser.length;i++){
        if(noLoser[i]!=noLoser[i+1]){
            NL.push(noLoser[i]);
        }
    }
    return [NL,oneLoser];
};
let merge=function(arr,lb,mid,ub){
    let i=lb;
    let j=mid+1;
    let k=lb;
    let b=[];
    while(i<=mid&&j<=ub){
        if(arr[i]<=arr[j]){
            b[k]=arr[i];
            i++;
            k++;
        }
        else{
            b[k]=arr[j];
            j++;
            k++;
        }
    }
    while(j<=ub){
        b[k]=arr[j];
        j++;
        k++;
    }
    while(i<=mid){
        b[k]=arr[i];
        i++;
        k++;
    }
    for(let k=lb;k<=ub;k++){
        arr[k]=b[k];
    }
}

let mergeSort=function(arr,lb,ub){

    if(lb<ub){
        let mid=Math.floor((lb+ub)/2);
        mergeSort(arr,lb,mid);
        mergeSort(arr,mid+1,ub);
        merge(arr,lb,mid,ub);
    }
}