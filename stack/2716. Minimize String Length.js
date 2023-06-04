/**
 * @param {string} s
 * @return {number}
 */
var minimizedStringLength = function(word) {
    
    let s=word.split('');
    s.sort();
    let st=[];
    for(let i=0;i<s.length;i++){
        if(s.length>0&&st[st.length-1]==s[i]){
            st.pop();
        }
        st.push(s[i]);
    }
    return st.length;
};