/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(str1,str2) {
    str1=str1.split('');
    str2=str2.split('');
    
    let carry=0;
    let d1;
    let d2;

    let ans="";
    let temp;
    let i=str1.length-1;
    let j=str2.length-1;

    while(i>=0&&j>=0){
        if(str1[i]=='1'&&str2[j]=='1'){
            temp='0';
            if(carry=='0'){
                temp='0';
                carry='1';
            }
            else{
                temp='1';
                carry='1';
            }

        }
        else if(str1[i]=='0'&&str2[j]=='0'){
            temp='0';
            if(carry=='0'){
                temp='0';
                carry='0';
            }
            else{
                temp='1';
                carry='0';
            }
        }
        else{
            if(carry=='0'){
                temp='1';
                carry='0';
            }
            else{
                temp='0';
                carry='1';
            }
        }
        i--;
        j--;
        ans+=temp;
    }
    while(i>=0){
        if(str1[i]=='0'){
            if(carry=='0'){
                temp='0';
                carry='0';
            }
            else{
                temp='1';
                carry='0';
            }
        }
        else if(str1[i]=='1'){
            if(carry=='0'){
                temp='1';
                carry='0';
            }
            else{
                temp='0';
                carry='1';
            }
        }
        i--;
        ans+=temp;
    }
    while(j>=0){
        if(str2[j]=='0'){
            if(carry=='0'){
                temp='0';
                carry='0';
            }
            else{
                temp='1';
                carry='0';
            }
        }
        else if(str2[j]=='1'){
            if(carry=='0'){
                temp='1';
                carry='0';
            }
            else{
                temp='0';
                carry='1';
            }
        }
        j--;
        ans+=temp;
    }
    if(carry=='1'){
        ans+=carry;
    }
    ans=ans.split('');
    let left=0;
    let right=ans.length-1;

    while(left<right){
        let temp=ans[left];
        ans[left]=ans[right];
        ans[right]=temp;
        left++;
        right--;
    }
    return ans.join('');
};
