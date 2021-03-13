import java.util.Scanner;

public class A3Q5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int si[][]= new int[m][n];//sea and island;
        int i,j,temp,result=0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                si[i][j]=in.nextInt();
            }
        }
        for(i=0;i<si.length;i++){
        for(j=0;j<si[0].length;j++){
        if(si[i][j]==1){
        result=Math.max((temp=countArea(si,i,j)),result);
        }
        }
        }System.out.println(result);
        }


        public static int countArea(int si[][],int i,int j){
        if(i<0||j<0||i>=si.length||j>=si[0].length||si[i][j]!=1) return 0;

        si[i][j]=0;
        int result = 0;
        result= 1+countArea(si,i+1,j)+countArea(si,i-1,j)+countArea(si,i,j+1)+countArea(si,i,j-1);
        return result;
        }

        }
