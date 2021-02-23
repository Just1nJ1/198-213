package Project2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * (...)
 * @author Haochen Ji, Yichen Chen
 */
public class Company {
    private Employee[] emplist;
    private int numEmployee;

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
     *
     * @param employee
     * @return
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
     *
     * @param employee
     * @return
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
     *
     * @param employee
     * @return
     */
    public boolean setHours(Employee employee) {
        int index = find(employee);
        if (index == -1 || !(new Parttime().equals(employee))){ return false; }
        ((Parttime)emplist[index]).setHours(((Parttime)employee).getHours());
        return true;
    } //set working hours for a part time

    /**
     *
     */
    public void processPayments() {
        for (int i = 0; i < numEmployee; i ++){
            emplist[i].calculatePayment();
        }
    } //process payments for all employees

    public int getNumEmployee() {
        return numEmployee;
    }

    /**
     *
     */
    public void print() {
        System.out.println("--Printing earning statements for all employees--");
        for (Employee e : emplist){
            if (e != null) {
                System.out.println(e);
            }
}
    } //print earning statements for all employees

    /**
     *
     */
    public void printByDepartment() {
        Arrays.sort(emplist, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1 == null){ return 1; }
                if (o2 == null){ return -1;}
                return o1.getProfile().getDepartment().compareTo(o2.getProfile().getDepartment());
            }
        });
        print();
    } //print earning stateme by departmentnts

    /**
     *
     */
    public void printByDate() {
        Arrays.sort(emplist, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1 == null){ return 1; }
                if (o2 == null){ return -1;}
                return o1.getProfile().getDateHired().compareTo(o2.getProfile().getDateHired());
            }
        });
        print();
    } //print earning statements by date hired
}
