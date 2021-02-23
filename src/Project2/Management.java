package Project2;

/**
 * (...)
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
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "::" + header + " Compensation $" + compensation;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Management;
    }

    /**
     *
     */
    @Override
    public void calculatePayment() {
        super.calculatePayment();
        setPayment(getPayment() + compensation);
    }
}
