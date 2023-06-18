/**
 * @param {number} mainTank
 * @param {number} additionalTank
 * @return {number}
 */
var distanceTraveled = function(mainTank, additionalTank) {
    let maxDistance=0;
    
    if(mainTank<5){
        return mainTank*10;
    }
    
    while(mainTank>=5){
        maxDistance+=10*5;
        if(additionalTank>0){
            mainTank=mainTank-5+1;
            additionalTank--;
        }
        else{
            mainTank=mainTank-5;
        }   
    }
    maxDistance+=10*mainTank;
    return maxDistance;
};