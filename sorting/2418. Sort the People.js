/**
 * @param {string[]} names
 * @param {number[]} heights
 * @return {string[]}
 */
var sortPeople = function(names, heights) {
    let n=heights.length;
    for(let i=0;i<n-1;i++){
        let swap=0;
        for(let j=0;j<n-1-i;j++){
            if(heights[j]<heights[j+1]){
                let temp1=heights[j];
                heights[j]=heights[j+1];
                heights[j+1]=temp1;
                swap=1;

                let temp2=names[j];
                names[j]=names[j+1];
                names[j+1]=temp2;
            }
        }
        if(swap==0){
            break;
        }
    }
    return names;
};