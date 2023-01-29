/**
 * @param {string} title
 * @return {string}
 */
var capitalizeTitle = function(title) {
    title=title.toLowerCase();
    title=title.split(' ');
    let bag=[];
    for(let i=0;i<title.length;i++){
        let s=title[i].split('');
        if(s.length<=2){
            s=s.join('');
            bag.push(s);
        }
        else{
            let t=s[0].toUpperCase();
            s[0]=t;
            s=s.join('');
            bag.push(s);
        }
        
    }
    bag=bag.join(' ');
    return bag;
};