public class Course {
    private String name;
    private int credit;
    private String grade;
    private String teacher;//a

    public Course(String name){
        this.name = name;
    }

    public Course(String name,int credit,String grade,String teacher){
        this.credit = credit;
        this.grade = grade;
        this.name = name;
        this.teacher = teacher;
    }//b

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public int getCredit(){
        return credit;
    }

    public void setGrade(String Grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setTeacher(String teacher){
        this.teacher = teacher;
    }

    public String getTeacher(){
        return teacher;
    }//c

    public String toString(String name){
        return name;
    }//d

    public String getCourseLevel(){
            if(grade.equals("junior")||grade.equals("senior")) return "major course";
        else if(grade.equals("freshman")||grade.equals("sophomore"))return "common course";
        else return "not valid query";
    }//e

    public String  getQualificationForCourse(String grade){
        if(getCourseLevel().equals("major course")&&(grade.equals("freshman")||grade.equals("sophomore")))
            return "You are not qualified for the course";
        else if(getCourseLevel().equals("common course")&&(grade.equals("junior")||grade.equals("senior")))
            return "You are not qualified for the course";
        else if(getCourseLevel().equals("major course")&&(grade.equals("junior")||grade.equals("senior")))
            return "You are qualified for the course";
        else if(getCourseLevel().equals("common course")&&(grade.equals("freshman")||grade.equals("sophomore")))
            return "You are qualified for the course";
        else return "not valid query";
        //f
    }

    public boolean isWithLab(){
        if(credit==3)return true;
        else return false;
    }//g
}
