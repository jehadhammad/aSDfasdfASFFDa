package ProjectMartyr;

public class Martyr {
    private String name;
    private String dateOfMartyrdom;

    public String getName() {
        return name;
    }

    public Martyr(String name, String dateOfMartyrdom) {
        this.name = name;
        this.dateOfMartyrdom = dateOfMartyrdom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfMartyrdom() {
        return dateOfMartyrdom;
    }

    public void setDateOfMartyrdom(String dateOfMartyrdom) {
        this.dateOfMartyrdom = dateOfMartyrdom;
    }
}
