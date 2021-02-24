package Project2;

import java.util.Arrays;

/**
 * An array-based container class that implements the employee database.
 * @author Haochen Ji, Yichen Chen
 */
public class Company {
    private Employee[] emplist;
    private int numEmployee;

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
        return -1;
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
        if (find(employee) == -1){
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
        if (index == -1){ return false; }
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
        if (index == -1 || !(new Parttime().equals(employee))){ return false; }
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
     */
    public void print() {
        System.out.println("--Printing earning statements for all employees--");
        for (Employee e : emplist){
            if (e != null) {
                System.out.println(e);
            }
}
    }

    /**
     * Print earning statement by departments.
     */
    public void printByDepartment() {
        Arrays.sort(emplist, (o1, o2) -> {
            if (o1 == null){ return 1; }
            if (o2 == null){ return -1;}
            return o1.getProfile().getDepartment().compareTo(o2.getProfile().getDepartment());
        });
        print();
    }

    /**
     * Print earning statements by date hired.
     */
    public void printByDate() {
        Arrays.sort(emplist, (o1, o2) -> {
            if (o1 == null){ return 1; }
            if (o2 == null){ return -1;}
            return o1.getProfile().getDateHired().compareTo(o2.getProfile().getDateHired());
        });
        print();
    }
}
