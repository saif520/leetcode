/**
 * @param {string[]} event1
 * @param {string[]} event2
 * @return {boolean}
 */
var haveConflict = function(event1, event2) {
    let start1=event1[0].split(':');
    let end1=event1[1].split(':');
    let start2=event2[0].split(':');
    let end2=event2[1].split(':');
    let t1=Number(start1[0])*60+Number(start1[1]);
    let t2=Number(end1[0])*60+Number(end1[1]);
    let t3=Number(start2[0])*60+Number(start2[1]);
    let t4=Number(end2[0])*60+Number(end2[1]);
    
    if((t3>=t1&&t3<=t2)||(t1>=t3&&t1<=t4)){
       return true;
    }
    return false;
};