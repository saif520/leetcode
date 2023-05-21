/**
 * @param {string} s
 * @return {number}
 */
var minLength = function(s) {
    s=s.split('');
    let st=[];
    let i=0;
    while(i<s.length){
        
        st.push(s[i]);
        if(st.length>=2&&st[st.length-2]=='A'&&st[st.length-1]=='B'){
            st.pop();
            st.pop();
        }
        else if(st.length>=2&&st[st.length-2]=='C'&&st[st.length-1]=='D'){
            st.pop();
            st.pop();
        }
        i++;
        
    }
    return st.length;
};