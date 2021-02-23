package Project2;

/**
 * Extends the Fulltime class and includes specific data and operations to a full-time employee with a management role.
 * @author Haochen Ji, Yichen Chen
 */
public class Management extends Fulltime {
    private int roles;
    private String header;
    private double compensation;

    /**
     *
     */
    public Management(){}

    /**
     *
     * @param p
     * @param salary
     * @param roles
     */
    public Management(Profile p, int salary, int roles){
        super(p, salary);
        this.roles = roles;
        switch (roles){
            case 1:
                header =  "Manager";
                compensation = 192.31;
                break;
            case 2:
                header =  "DepartmentHead";
                compensation = 365.38;
                break;
            case 3:
                header =  "Director";
                compensation = 461.54;
                break;
            default:
        }
    }

    /**
     * Output a string.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "::" + header + " Compensation $" + compensation;
    }

    /**
     * Make comparation.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Management;
    }

    /**
     * Calculate payments.
     */
    @Override
    public void calculatePayment() {
        super.calculatePayment();
        setPayment(getPayment() + compensation);
    }
}
