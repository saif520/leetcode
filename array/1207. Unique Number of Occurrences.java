class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.get(arr[i])==null?1:map.get(arr[i])+1);
        }
        
        HashSet<Integer>set=new HashSet<>();
        for(Map.Entry e:map.entrySet()){
            set.add((int)e.getValue());
        }
        
        if(set.size()==map.size()){
            return true;
        }
        return false;
    }
}