package Entity;

public enum Gender {
    M("Male"), F("Female"), O("Other");
    private String genderlabel;

    Gender(String genderlabel) {
        this.genderlabel = genderlabel;
    }

    public String getGenderlabel() {
        return genderlabel;
    }

    public void setGenderlabel(String genderlabel) {
        this.genderlabel = genderlabel;
    }
}
