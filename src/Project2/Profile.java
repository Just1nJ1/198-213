package Project2;

public class Profile {
    private String name;
    private String department;
    private Date dateHired;
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Profile
            && name.equals(((Profile) obj).name)
            && department.equals(((Profile) obj).department)
            && dateHired.equals(((Profile) obj).dateHired);
    }
}
