/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function(s) {
    s=s.split('');
    let st=[];
    for(let i=0;i<s.length;i++){
        st.push(s[i]);
        if(st.length>=2&&st[st.length-1].toLowerCase()==st[st.length-2].toLowerCase()&&st[st.length-1]!=st[st.length-2]){
            st.pop();
            st.pop();
        }
    }
    if(st.length==0){
        return "";
    }
    return st.join('');
};