class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex=rowIndex+1;
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>zero=new ArrayList<>();
        if(rowIndex==0) return zero;
        List<Integer>firstRow=new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        if(rowIndex==1) return firstRow;
        for(int i=1;i<rowIndex;i++){
            List<Integer>prevRow=result.get(i-1);
            ArrayList<Integer>row=new ArrayList<>();
            row.add(1);
            for(int j=0;j<i-1;j++){
                row.add(prevRow.get(j)+prevRow.get(j+1));
            }
            row.add(1);
            result.add(row);
        }
        return result.get(rowIndex-1);
    }
}