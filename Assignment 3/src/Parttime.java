package Project3;

/**
 * Extends the Employee class and includes specific data and operations to a part-time employee.
 * @author Haochen Ji, Yichen Chen
 */
public class Parttime extends Employee {
    private static final int ADDITION_THRESHOLD = 80;
    private static final double EXTRA_RATE = 0.5;
    private int hours;
    private double payRate;

    /**
     * Constructs a part time employee instance without any field.
     * This is used to create a temp instance and to check the type of employee.
     */
    Parttime(){
        this(null, 0);
    }

    /**
     * Constructs a part time employee instance with its profile and payrate.
     * @param p the profile of the part time employee
     * @param payRate the pay rate ($/hour) of the part time employee
     */
    public Parttime(Profile p, double payRate){
        super(p);
        hours = 0;
        this.payRate = payRate;
    }

    /**
     * Constructs a part time employee instance with its profile and working hours
     * @param p the profile of the part time employee
     * @param hours the working hours of the part time employee
     */
    public Parttime(Profile p, int hours){
        super(p);
        this.hours = hours;
    }

    /**
     * Constructs a part time employee instance with its profile and working hours
     * @param p the profile of the part time employee
     * @param payRate the pay rate of the part time employee
     * @param hours the working hours of the part time employee
     */
    public Parttime(Profile p, double payRate, int hours){
        super(p);
        this.hours = hours;
        this.payRate = payRate;
    }

    /**
     * Sets working hours for this part time employee
     * @param hours working hours to be sat
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Gets working hours of this part time employee
     * @return working hours of this part time employee
     */
    public int getHours(){
        return hours;
    }

    /**
     * Returns a string representation of this part time employee.
     * @return a string representation of this part time employee.
     */
    @Override
    public String toString() {
        return super.toString() + "::PART TIME::Hourly Rate $"
                + String.format("%.2f", payRate) + "::Hours worked this period: " + hours;
    }

    /**
     * Checking if the obj is an instance of part time employee.
     * @param obj the employee to be checked
     * @return true if the obj is a part time employee instance
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Parttime;
    }

    /**
     * Calculating payment of this part time employee by certain equation.
     */
    @Override
    public void calculatePayment() {
        double payment = hours * payRate;
        if (hours > ADDITION_THRESHOLD){
            payment += (hours-ADDITION_THRESHOLD)*payRate*EXTRA_RATE;
        }
        setPayment(payment);
    }
}
