import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class A2Q4 {
    public static void main(String[] args) {
        if (0 == args.length) return;
        int n = args[0].length();
        double[] num = new double[3];//
        char[] cal = new char[2];//
        int nums = 0;
        int cals = 0;




        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        String strNumber = args[0];


        try {
            String a = se.eval(strNumber).toString();
            System.out.println(a);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}