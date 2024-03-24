class Solution {
public:
    int maximumLengthSubstring(string s) {
        map<char,int>map;
        int left=0;
        int right=0;
        int max_len=0;
        for(right=0;right<s.size();right++){
            if(map.find(s[right])!=map.end()){
                map[s[right]]++;
                while(map[s[right]]>2){
                    map[s[left]]--;
                    if(map[s[left]]==0){
                        map.erase(s[left]);
                    }
                    left++;
                }
            }
            else{
                map[s[right]]++;
            }
            max_len=max(max_len,right-left+1);
        }
        return max_len;
    }
};