/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLucky = function(s, k) {
    let obj={'a':1,'b':2,'c':3,'d':4,'e':5,'f':6,'g':7,'h':8,'i':9,'j':10,'k':11,'l':12,
    'm':13,'n':14,'o':15,'p':16,'q':17,'r':18,'s':19,'t':20,'u':21,'v':22,'w':23,'x':24,'y':25,'z':26};
    let str="";
    for(let i=0;i<s.length;i++){
        str+=obj[s[i]];
    }
    let sum=0;
    let i=0;
    while(i<k){
        sum=0;
        str=str.split('');
        for(let j=0;j<str.length;j++){
            let t=+str[j];
            sum=sum+t;
        }
        str=sum.toString();
        i++;
    }
    return sum;
};