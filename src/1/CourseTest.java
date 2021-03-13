import java.util.ArrayList;
import java.util.Scanner;

public class CourseTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Would you like to create some courses: yes or no ? ");
        String s1 = in.nextLine();
        //in.nextLine();
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<String> list3 = new ArrayList<String>();
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<String>();
        ArrayList<Boolean> list6 = new ArrayList<Boolean>();
        ArrayList<String> list7 = new ArrayList<String>();
        /*int m = 1000000;
        String[] strArray1 = new String[m];
        String[] strArray2 = new String[m];
        String[] strArray3 = new String[m];
        String[] strArray4 = new String[m];
        String[] strArray5 = new String[m];*/
        int i = 0;
        do {
            System.out.println("Please input the course name: ");
            String name = in.nextLine();
            list1.add(name);
            System.out.println("Please input the course credit: ");
            int credit = in.nextInt();
            in.nextLine();
            list2.add(credit);
            System.out.println("Please input the course grade: ");
            String grade = in.nextLine();
            list3.add(grade);
            System.out.println("Please input the course teacher: ");
            String teacher = in.nextLine();
            list4.add(teacher);
            Course a = new Course(name,credit,grade,teacher);
            a.setName(name);
            a.setCredit(credit);
            a.setGrade(grade);
            a.setTeacher(teacher);
            list5.add(a.getCourseLevel());
            list6.add(a.isWithLab());
            list7.add(a.getQualificationForCourse(grade));
            System.out.println("Would you like to create some courses: yes or no ? ");
            s1 = in.nextLine();
            i++;
        } while (s1.equals("yes"));//h

        System.out.println("Would you like to obtain course information: yes or no ? ");
        String s6 = in.next();
        do{
            System.out.print("There are 3 courses in the system, please pick No.");
            int x = in.nextInt();
            System.out.printf("The course level is: %s\n" +
                    "Is this course with lab? %s\n" +
                    "Please enter your grade: \n",list5.get(x),list6.get(x));
            String grade = in.nextLine();
            System.out.printf("The result for your qualification to enroll in the course is: %s\n" +
                    "Input a course credit: \n",list7.get(x));
            int cr = in.nextInt();
            in.nextLine();
            String cre="";
            for(int k = 0;k<list1.size();k++){
                if(list2.get(k)==cr){
                    cre = cre + list1.get(k)+",";
                }
            }
            System.out.printf("The courses with %d credits are [%s]\n" +
                    "Input a teacher's name:\n ",cr,cre);
            String tn = in.nextLine();
            String tns = "";
            for(int k = 0;k<list1.size();k++){
                if(list4.get(k).equals(tn)){
                    tns = tns + list1.get(k)+",";
                }
            }
            System.out.printf("The courses taught by %s are [%s]\n ",tn,tns);
            System.out.println("Would you like to obtain course information: yes or no ? ");
            s6 = in.nextLine();
        }while(s6.equals( "yes" ));//i

        System.out.println("Would you like to obtain course information after removing certain courses: yes or no ? ");
        String s7 = in.nextLine();
        int z = 1;
        do{System.out.println("Please pick the index of the course you want to remove:");
            int y = in.nextInt();
            in.nextLine();
            list1.remove(y);
            String re = "";
            for(int j = 0;j<list1.size();j++){
                if(j!=list1.size()-1){re =re+list1.get(j) + ",";}
                else {re =re+list1.get(j);}
            }
            System.out.printf("The remaining courses are [%s]",re);
            System.out.println("Would you like to obtain course information after removing certain courses: yes or no ? ");
            s7 = in.nextLine();
        }while (s7.equals("yes"));
         /*int z = 1;
        do{
            System.out.println("Please pick the index of the course you want to remove:");
            int y = in.nextInt();
            //strArray1[y] = "";
           for(int j = y;j<list1.size()-z;j++){
                list1[j] = strArray1[j+1];
            }
            String re = "";
            for(int j = 0;j<strArray1.length-z;j++){
                if(j!=strArray1.length-2){re =re+strArray1[j] + ",";}
                else {re =re+strArray1[j];}
            }
            System.out.printf("The remaining courses are [%s]",re);
            System.out.println("Would you like to obtain course information after removing certain courses: yes or no ? ");
            s7 = in.next();
            z++;
        }while(s7.equals("yes"));*/
    }
}
