import java.util.Scanner;
public class dsaa20190021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        int s[] = new int[testcases];

        for(int i = 0;i<testcases;i++){
            s[i] = in.nextInt();
            int n[] = new int[s[i]];
            for(int j = 0;j<n.length;j++){
                n[j] = in.nextInt();
            }

            for(int j = 0;j<n.length-1;j++){
                for(int m = 1;m<n.length;m++){
                    if (n[m-1] < n[m]){
                        int temp = n[m];
                        n[m] = n[m-1];
                        n[m-1] = temp;
                    }
                }
            }
            int count = 0;
            for(int j = 0;j<n.length;j++){
                if(n[2]==n[j]){
                    count++;
                }
            }
            if(count > 1){
                System.out.println("wa");
            }else System.out.println(n[2]);

        }//降序 ，升序将if (arr[m-1] < arr[m])改为if (arr[m-1] > arr[m])




    }



}