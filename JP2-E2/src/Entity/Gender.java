package Entity;

public enum Gender {
    M("Male"), F("Female");
    private String genderLable;
    private Gender(String genderLable) {
        this.genderLable = genderLable;
    }
    public String getGenderLable() {
        return genderLable;
    }
}