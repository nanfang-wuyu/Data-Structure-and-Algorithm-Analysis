package Account;



public class Customer{

    private String firstName;
    private String lastName;
    private String ssn;
    private Gender gender;

    public Customer(String firstName, String lastName, Gender gender, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.gender = gender;
    }

    public void setFirstName(String firstname){this.firstName = firstName;}
    public void setLastName(String lastname){this.lastName = lastName;}
    public void setSsn(String ssn){this.ssn = ssn;}
    public void setGender(Gender gender){this.gender = gender;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getSsn(){return ssn;}
    public Gender getGender(){return gender;}

    public static boolean checkName(String name){
       if ((name.matches("[a-zA-Z]*"))){
        return true;
        }
        return false;
    }
    //equalsIgnoreCase

    public static String formatName(String name){
        String Name=name.toUpperCase();
        Name.replace(name.charAt(0),Name.charAt(0));
        //String LastName=lastName.toUpperCase();
        //lastName.replace(lastName.charAt(0),LastName.charAt(0));
        return name;
    }

    public static boolean checkSSN(String ssn){
        if(ssn.length()==8&&ssn.charAt(0)!='0')
        {
        for(int i=0;i<ssn.length();i++){
            if (Character.isDigit(ssn.charAt(i))){

            return true;
        }
        }
        }return  false;
    }

}
