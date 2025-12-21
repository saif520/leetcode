class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int cnt=0;
        for(int j=0;j<strs[0].size();j++){
            char c=strs[0][j];
            for(int i=1;i<strs.size();i++){
                if(strs[i][j]>=c){
                    c=strs[i][j];
                }
                else{
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
};