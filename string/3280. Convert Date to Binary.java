class Solution {
    public String convertDateToBinary(String date) {
        int year=Integer.parseInt(date.substring(0,4));
        int month=Integer.parseInt(date.substring(5,7));
        int day=Integer.parseInt(date.substring(8,10));
        String y=Integer.toBinaryString(year);
        String m=Integer.toBinaryString(month);
        String d=Integer.toBinaryString(day);
        return y+"-"+m+"-"+d;
    }
}