package a5.a5;

public class Customer {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String socialSecurityNumber;

    public void setFirstName(String name) {
        firstName = name;
    }

    public void setLastName(String name) {
        lastName = name;
    }

    public void setGender(Gender d) {
        gender = d;
    }

    public void setSocialSecurityNumber(String ssn) {
        socialSecurityNumber = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public Customer(String firstName, String lastName, Gender gender, String ssn) {
        firstName = formatName(firstName);
        lastName = formatName(lastName);
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setSocialSecurityNumber(ssn);
    }

    public static boolean checkName(String name) {
        char[] chars = name.toCharArray();
        for(char c : chars) {
            if(c < 'A' || c > 'z') {
                return false;
            }
        }
        return true;
    }

    public static String formatName(String name) {
        char[] chars = name.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(i == 0) {
                chars[i] = Character.toUpperCase(chars[i]);
            } else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return new String(chars);
    }

    public static boolean checkSSN(String ssn) {
        if(ssn.length() != 8) return false;
        char[] chars = ssn.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(i == 0 && (chars[i] < '1' || chars[i] > '9')) {
                return false;
            } else {
                if(chars[i] < '0' || chars[i] > '9') {
                    return false;
                }
            }
        }
        return true;
    }
}
