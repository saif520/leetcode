class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            String temp="";
            for(int j=i;j<s.length();j++){
                temp+=s.charAt(j);
                // System.out.println(temp);
                map.put(temp,map.get(temp)==null?1:map.get(temp)+1);
            }
        }
         // System.out.println(map);
        int max=-1;
        for(Map.Entry e:map.entrySet()){
            
            String str=(String)e.getKey();
            int count=(int)e.getValue();
            
            boolean flag=true;
            for(int i=0;i<str.length()-1;i++){
                if(str.charAt(i)!=str.charAt(i+1)){
                    flag=false;
                    break;
                }
            }
            
            if(flag==true&&count>=3){
                if(str.length()>max){
                    max=str.length();
                }
            }
        }
        return max;
    }
}