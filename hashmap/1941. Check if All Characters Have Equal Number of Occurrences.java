class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.get(s.charAt(i))==null?1:map.get(s.charAt(i))+1);
        }
        int temp=0;
        for(Map.Entry e:map.entrySet()){
            temp=(int)e.getValue();
            break;
        }
        for(Map.Entry e:map.entrySet()){
            if((int)e.getValue()!=temp){
                return false;
            }
        }
        return true;
    }
}