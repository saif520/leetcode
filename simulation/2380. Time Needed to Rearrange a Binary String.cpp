class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        int count=0;
        while(true){
            bool flag=false;
            for(int i=0;i<s.size();i++){
                if(s[i]=='0'&&s[i+1]=='1'){
                    s[i]='1';
                    s[i+1]='0';
                    i++;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
            else{
                count++;
            }
        }
        return count;
    }
};