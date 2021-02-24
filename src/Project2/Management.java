package Project2;

/**
 * Extends the Fulltime class and includes specific data and operations to a full-time employee with a management role.
 * @author Haochen Ji, Yichen Chen
 */
public class Management extends Fulltime {
    public static final double MANAGER_COMPENSATION = 192.31;
    public static final double DEPARTMENT_HEAD_COMPENSATION = 365.38;
    public static final double DIRECTOR_COMPENSATION = 461.54;

    private int roles;
    private String header;
    private double compensation;

    /**
     * Constructs an employee instance with its profile.
     * @param p the profile of the employee
     * @param salary the annual salary of the employee
     * @param roles the role of the full time employee:
     *              1 represents manager; 2 represents department head; 3 represents director
     */
    public Management(Profile p, int salary, int roles){
        super(p, salary);
        this.roles = roles;
        switch (roles){
            case 1:
                header =  "Manager";
                compensation = MANAGER_COMPENSATION;
                break;
            case 2:
                header =  "DepartmentHead";
                compensation = DEPARTMENT_HEAD_COMPENSATION;
                break;
            case 3:
                header =  "Director";
                compensation = DIRECTOR_COMPENSATION;
                break;
            default:
        }
    }

    /**
     * Returns a string representation of this management employee.
     * @return a string representation of this management employee
     */
    @Override
    public String toString() {
        return super.toString() + "::" + header + " Compensation $" + compensation;
    }

    /**
     * Checking if the obj is an instance of employee.
     * @param obj the employee to be checked
     * @return true if the obj is a management employee instance
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Management;
    }

    /**
     * Calculating payment of this part time employee by certain equation.
     */
    @Override
    public void calculatePayment() {
        super.calculatePayment();
        setPayment(getPayment() + compensation);
    }
}
