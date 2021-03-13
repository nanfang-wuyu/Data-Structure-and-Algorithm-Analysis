public class Main3 {
    public static void main(String[] args){
        float GPA=0;
        float score = Float.parseFloat(args[0]);

        if(score >= 80)
            System.out.println("You passed the exam.");
        else
            System.out.println("You failed in the exam");

        if(score >= 95)
            GPA = (float) 4.0;
        else if(score>= 85)
        //else
        {
            System.out.println("Invalide grade");
        return;
        }
        System.out.printf("Your score is %.1f,the GPA is %.1f\n",score,GPA);

    }
}