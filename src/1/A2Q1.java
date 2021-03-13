
public class A2Q1 {
    public static void main(String[] args){
        int year=Integer.parseInt (args[0]);
        String []array1={"geng", "xin", "ren", "gui","jia", "yi", "bing", "ding", "wu", "ji"};
        String []array2={"shen", "you", "xu","hai","zi", "chou", "yin", "mao", "chen", "si", "wu", "wei" };
        String []array3={"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Sheep"};
        String Stem,Branch,Animal;
        int i=0;
        int j=0;
        int k=0;
        i=year%10;
        Stem=array1[i];
        j=year%12;
        Branch=array2[j];
        k=year%12;
        Animal=array3[k];

        System.out.printf("%d is the year of %s-%s. Also %s year." ,year,Stem,Branch,Animal);
    }
}
