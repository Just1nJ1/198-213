package Project3;

/**
 * An array-based container class that implements the employee database.
 * @author Haochen Ji, Yichen Chen
 */
public class Company {
    private Employee[] emplist;
    private int numEmployee;
    public static final int NOT_FOUND = -1;

    /**
     * Constructs an Company instance with an empty list.
     */
    public Company(){
        emplist = new Employee[4];
        numEmployee = 0;
    }

    /**
     * Find the employee with the same profile.
     * @param employee target employee
     * @return the index of the target employee; -1 if not exist
     */
    private int find(Employee employee) {
        for (int i = 0; i < numEmployee; i++) {
            if (emplist[i].getProfile().equals(employee.getProfile())){ return i; }
        }
        return NOT_FOUND;
    }

    /**
     * Extends the length of emplist by 4.
     */
    private void grow() {
        Employee[] temp = new Employee[emplist.length + 4];
        System.arraycopy(emplist, 0, temp, 0, emplist.length);
        emplist = temp;
    }

    /**
     * Adding an employee to emplist if the employee does not exist.
     * @param employee the employee to be added to the list
     * @return true if adding successfully; false if the employee already exists
     */
    public boolean add(Employee employee) {
        if (find(employee) == NOT_FOUND){
            if (numEmployee == emplist.length){ grow(); }
            emplist[numEmployee++] = employee;
            return true;
        }
        return false;
    }

    /**
     * Removing the specified employee from the emplist and maintaining the same sequence.
     * If the list does not contain the employee, it is unchanged.
     * @param employee employee to be removed from emplist, if present
     * @return true if emplist contained the specified employee
     */
    public boolean remove(Employee employee) {
        int index = find(employee);
        if (index == NOT_FOUND){ return false; }
        if (numEmployee - 1 - index >= 0)
            System.arraycopy(emplist, index + 1, emplist, index, --numEmployee - index);
        emplist[numEmployee] = null;
        return true;
    }

    /**
     * Setting working hours for a part time employee.
     * @param employee target employee that has the same profile, and his working hours
     * @return true if emplist contained the specified employee
     */
    public boolean setHours(Employee employee) {
        int index = find(employee);
        if (index == NOT_FOUND || !(new Parttime().equals(employee))){ return false; }
        ((Parttime)emplist[index]).setHours(((Parttime)employee).getHours());
        return true;
    }

    /**
     * Process payments for all employees.
     * It will call calculatePayment for every employees in the emplist
     */
    public void processPayments() {
        for (int i = 0; i < numEmployee; i ++){
            emplist[i].calculatePayment();
        }
    }

    /**
     * Gets number of employee
     * @return number of employee
     */
    public int getNumEmployee() {
        return numEmployee;
    }

    /**
     * Print earning statements for all employees.
     * @return the String instance that contains the information to be printed.
     */
    public String print() {
        String output = "";
        for (Employee e : emplist){
            if (e != null) {
                output += e + "\n";
            }
        }
        return output;
    }

    /**
     * Sort the employees list by departments.
     */
    public void sortByDepartment() {
        for (int i = 0; i < numEmployee; i++)
        {
            for (int j = i + 1; j < numEmployee; j++) {
                if (emplist[i].getProfile().getDepartment().compareTo(emplist[j].getProfile().getDepartment()) > 0)
                {
                    Employee temp = emplist[i];
                    emplist[i] = emplist[j];
                    emplist[j] = temp;
                }
            }
        }
    }

    /**
     * Sort the employees list by date hired.
     */
    public void sortByDate() {
        for (int i = 0; i < numEmployee; i++)
        {
            for (int j = i + 1; j < numEmployee; j++) {
                if (emplist[i].getProfile().getDateHired().compareTo(emplist[j].getProfile().getDateHired()) > 0)
                {
                    Employee temp = emplist[i];
                    emplist[i] = emplist[j];
                    emplist[j] = temp;
                }
            }
        }
    }
}
