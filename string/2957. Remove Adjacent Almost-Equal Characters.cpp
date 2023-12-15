class Solution {
public:
    int removeAlmostEqualCharacters(string word) {
        int n=word.size();
        int i=1;         
        int count=0;
        while(i<n){
            if(abs(word[i]-word[i-1])==1||word[i]==word[i-1]){
                count++;
                i=i+2;
                continue;
            }
            i++;
        }
        return count;
    }
};