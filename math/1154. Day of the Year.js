/**
 * @param {string} date
 * @return {number}
 */
var dayOfYear = function(date) {
    let year=+date.slice(0,4);
    let month=+date.slice(5,7);
    let day=+date.slice(8,10);
    
    let leaparr=[31,28,31,30,31,30,31,31,30,31,30,31];

    if(year%400==0||(year%4==0&&year%100!=0)){
        leaparr[1]=29;
    }
    
    for(let i=1;i<leaparr.length;i++){
        leaparr[i]=leaparr[i]+leaparr[i-1];
    }
    
    if(month==1) return day;
    return leaparr[month-2]+day;
};