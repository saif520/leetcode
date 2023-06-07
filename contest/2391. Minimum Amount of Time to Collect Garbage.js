/**
 * @param {string[]} garbage
 * @param {number[]} travel
 * @return {number}
 */
var garbageCollection = function(garbage, travel) {
    
    for(let i=1;i<travel.length;i++){
        travel[i]=travel[i]+travel[i-1];
    }
    
    let gcount=0;
    let pcount=0;
    let mcount=0;
    let g=-1;
    let p=-1;
    let m=-1;
    for(let i=0;i<garbage.length;i++){
        let str=garbage[i];
        
        for(let j=0;j<str.length;j++){
            if(str[j]=='G'){
                gcount++;
                g=i;
            }
            else if(str[j]=='P'){
                pcount++;
                p=i;
            }
            else if(str[j]=='M'){
                mcount++;
                m=i;
            }
        }
    }

    if(g==0){
        g=-1;
    }
    if(p==0){
        p=-1
    }
    if(m==0){
        m=-1;
    }
    
    let gtravel=g==-1?0:travel[g-1];
    let ptravel=p==-1?0:travel[p-1];
    let mtravel=m==-1?0:travel[m-1];
    
    return gcount+gtravel+pcount+ptravel+mcount+mtravel;
     
};