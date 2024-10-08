package Entity;

public enum Gender {
    M("male"), F("female"), O("other");
    private String genderLable;

    Gender(String genderLable) {
        this.genderLable = genderLable;
    }
    public String getGenderLable() {
        return genderLable;
    }

    public void setGenderLable(String genderLable) {
        this.genderLable = genderLable;
    }
}
