package Project3;

/**
 * Define the profile of an employee with the following.
 * @author Haochen Ji, Yichen Chen
 */
public class Profile {
    private String name;
    private String department;
    private Date dateHired;

    /**
     * Constructs a profile with given variables.
     * @param name the name stored in the profile
     * @param department the department code stored in the profile
     * @param date the hired date stored in the profile
     */
    public Profile(String name, String department, Date date){
        this.name = name;
        this.department = department;
        this.dateHired = date;
    }

    /**
     * Gets department field.
     * @return department field
     */
    public String getDepartment(){ return department; }

    /**
     * Gets dateHired field.
     * @return dateHired field
     */
    public Date getDateHired(){ return dateHired; }

    /**
     * Returns a string representation of this profile.
     * @return a string representation of this profile.
     */
    @Override
    public String toString() {
        return name + "::" + department + "::" + dateHired;
    }

    /**
     * Comparing two profiles by their name, department code, and hired date.
     * @param obj the profile to be compared for equality with this profile
     * @return true if obj is equal to this profile
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Profile
            && name.equals(((Profile) obj).name)
            && department.equals(((Profile) obj).department)
            && dateHired.compareTo(((Profile) obj).dateHired) == 0;
    }
}
