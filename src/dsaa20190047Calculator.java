import java.util.*;

public class dsaa20190047Calculator {

    static int top = -1;
    static char[] S = new char[550];
    static int[] I = new int[550];


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int r = 0;r<T;r++){
            top = -1;
            S = new char[550];
            I = new int[550];
            String str = in.next();
            int length = str.length();
            String output = "";
            for(int i = 0;i<length+1;i++){
                if(i == length){
                    while(top!=-1)output += pop();
                }//读完整句导出栈里剩下所有元素
                else {
                    char p = str.charAt(i);
                    if (Character.isDigit(p)) {
                        output += p;
                        if(i!=0){
                            if(S[top]=='p'||S[top]=='q'||S[top]=='~'){
                                while(top!=-1&&S[top]!='('&&level(p) >= level(S[top]))output += pop();
                            }
                        }
                    }//如果是数字不入栈直接导出
                    else if(i==0){
                        if(p=='+'){p='p';}
                        else if(p=='-'){p='q';}
                        push(p);
                    }//如果栈为空不用判断直接入栈
                    else {
                        if((p=='+'||p=='-')&&str.charAt(i-1)!=')'&&!Character.isDigit(str.charAt(i-1))){
                            if(p=='+'){p='p';}
                            else if(p=='-'){p='q';}
                        }
                        output = ifPrior(p, output, length, i);
                    }//判断符号
                }
            }
            //System.out.println(output);
            top = -1;
            calculate(output,output.length());
        }
    }

    static char pop(){
        top--;
        return S[top+1];
    }
    static void push(char p){
        top++;
        S[top] = p;
    }
    static int popi(){
        top--;
        return I[top+1];
    }
    static void pushi(int p){
        top++;
        I[top] = p;
    }
    static String ifPrior(char p, String output, int length, int i){
        if(top==-1){
            push(p);
        }//如果栈为空不用判断直接入栈
        else if(p==')'){
            while (S[top]!='('){
                output += pop();
            }top--;
        }//导出括号内所有运算符
        else if(level(p)<level(S[top])||level(p)==2)push(p);//优先级更高入栈
        else//优先级相同或更低先出栈后入栈
            {
            while (level(p) >= level(S[top]) && S[top] != '(') {
                output += pop();
                 if(top == -1)break;
            }
            push(p);
        }
        return output;
    }

    static void calculate(String output, int n){
        for(int i = 0;i<n;i++) {
            char p = output.charAt(i);
            if (Character.isDigit(p)){
                pushi(Integer.parseInt(String.valueOf(p)));
            }else if(p=='p'){

            }else if(p=='q'){
                pushi(-popi());
            }else if(p=='~'){
                pushi(~popi());
            }else if(p=='*'){
                pushi(popi()*popi());
            }else if(p=='+'){
                pushi(popi()+popi());
            }else if(p=='-'){
                int a = popi();
                int b = popi();
                pushi(b-a);
            }else if(p=='&'){
                pushi(popi()&popi());
            }else if(p=='^'){
                pushi(popi()^popi());
            }else if(p=='|'){
                pushi(popi()|popi());
            }
        }
        System.out.println(I[top]);
    }

    static int level(char p){
        if(p=='('){
            return 1;
        }else if(p=='~'||p=='p'||p=='q'){
            return 2;
        }else if(p=='*'){
            return 3;
        }else if(p=='+'||p=='-'){
            return 4;
        }else if(p=='&'){
            return 5;
        }else if(p=='^'){
            return 6;
        }else if(p=='|'){
            return 7;
        }else if(p==')'){
            return 0;
        }return -1;
    }
}
