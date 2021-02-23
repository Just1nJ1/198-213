package Project2;

/**
 * (...)
 * @author Haochen Ji, Yichen Chen
 */
public class Profile {
    private String name;
    private String department;
    private Date dateHired;

    public Profile(String name, String department, Date date){
        this.name = name;
        this.department = department;
        this.dateHired = date;
    }

    public String getDepartment(){ return department; }

    public Date getDateHired(){ return dateHired; }

    @Override
    public String toString() {
        return name + "::" + department + "::" + dateHired;
    } //(...)

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Profile
            && name.equals(((Profile) obj).name)
            && department.equals(((Profile) obj).department)
            && dateHired.equals(((Profile) obj).dateHired);
    } //(...)
}
