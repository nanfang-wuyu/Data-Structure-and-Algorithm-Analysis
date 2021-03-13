package Account;

public enum Gender {
    MALE("MALE"),
    FAMALE("FAMALE");

    private final String gender;

    private Gender(String gender){
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
