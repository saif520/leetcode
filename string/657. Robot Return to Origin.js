/**
 * @param {string} moves
 * @return {boolean}
 */
var judgeCircle = function(moves) {
    moves=moves.split('');
    let hor=0;
    let ver=0;
    for(let i=0;i<moves.length;i++){
        if(moves[i]=='U'){
            ver++;
        }
        else if(moves[i]=='D'){
            ver--;
        }
        else if(moves[i]=='R'){
            hor++;
        }
        else if(moves[i]=='L'){
            hor--;
        }
    }
    return hor==0&&ver==0;
};