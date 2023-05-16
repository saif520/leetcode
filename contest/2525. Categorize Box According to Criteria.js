/**
 * @param {number} length
 * @param {number} width
 * @param {number} height
 * @param {number} mass
 * @return {string}
 */
var categorizeBox = function(length, width, height, mass) {
    let bulky=false;
    if(length>=Math.pow(10,4)||width>=Math.pow(10,4)||height>=Math.pow(10,4)||(length*width*height)>=Math.pow(10,9)){
        bulky=true;
    }
    let heavy=false;
    if(mass>=100){
        heavy=true;
    }
    if(bulky==true&&heavy==true){
        return "Both";
    }
    else if(bulky==false&&heavy==false){
        return "Neither";
    }
    else if(bulky==true&&heavy==false){
        return "Bulky";
    }
    else if(bulky==false&&heavy==true){
        return "Heavy";
    }
};