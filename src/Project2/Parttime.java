package Project2;

/**
 * (...)
 * @author Haochen Ji, Yichen Chen
 */
public class Parttime extends Employee {
    private int hours;
    private double payRate;

    public Parttime(){ hours = 0; }

    public Parttime(Profile p, double payRate){
        super(p);
        hours = 0;
        this.payRate = payRate;
    }

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

    @Override
    public String toString() {
        return super.toString() + "::PART TIME::Hourly Rate $" + String.format("%.2f", payRate) + "::Hours worked this period: " + hours;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Parttime;
    }

    @Override
    public void calculatePayment() {
        double payment = hours * payRate;
        if (hours > 80){
            payment += (hours-80)*payRate/2;
        }
        setPayment(payment);
    }
}
