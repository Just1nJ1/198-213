package Project2;

/**
 * Extends the Employee class and includes specific data and operations to a part-time employee.
 * @author Haochen Ji, Yichen Chen
 */
public class Parttime extends Employee {
    private int hours;
    private double payRate;

    /**
     *
     */
    public Parttime(){ hours = 0; }

    /**
     *
     * @param p
     * @param payRate
     */
    public Parttime(Profile p, double payRate){
        super(p);
        hours = 0;
        this.payRate = payRate;
    }

    /**
     *
     * @param p
     * @param hours
     */
    public Parttime(Profile p, int hours){
        super(p);
        this.hours = hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours(){
        return hours;
    }

    /**
     * Output a string.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "::PART TIME::Hourly Rate $" + String.format("%.2f", payRate) + "::Hours worked this period: " + hours;
    }

    /**
     * Make comparation.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Parttime;
    }

    /**
     * Calculate payments.
     */
    @Override
    public void calculatePayment() {
        double payment = hours * payRate;
        if (hours > 80){
            payment += (hours-80)*payRate/2;
        }
        setPayment(payment);
    }
}
