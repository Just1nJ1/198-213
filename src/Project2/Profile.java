package Project2;

/**
 * Define the profile of an employee with the following.
 * @author Haochen Ji, Yichen Chen
 */
public class Profile {
    private String name;
    private String department;
    private Date dateHired;

    /**
     *
     * @param name
     * @param department
     * @param date
     */
    public Profile(String name, String department, Date date){
        this.name = name;
        this.department = department;
        this.dateHired = date;
    }

    public String getDepartment(){ return department; }

    public Date getDateHired(){ return dateHired; }

    /**
     * Output a string.
     * @return
     */
    @Override
    public String toString() {
        return name + "::" + department + "::" + dateHired;
    }

    /**
     * Make comparation.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Profile
            && name.equals(((Profile) obj).name)
            && department.equals(((Profile) obj).department)
            && dateHired.compareTo(((Profile) obj).dateHired) == 0;
    }
}
