import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
  	int mat[][]=new int[n][m];
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        mat[i][j]=sc.nextInt();
      }
    }
    int bag[];
    int l=n*m;
    int c=0;
    bag=new int[l];
    for(int i=0;i<n;i++){
      if((i+1)%2!=0){
        for(int j=0;j<m;j++){
          bag[c]=mat[i][j];
          c++;
        }
      }else{
        for(int j=m-1;j>=0;j--){
          bag[c]=mat[i][j];
          c++;
        }
      }
    }
   	for(int i=0;i<l;i++){
      System.out.print(bag[i]+" ");
    } 
	}
}