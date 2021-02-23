package Project2;

/**
 * (...)
 * @author Haochen Ji, Yichen Chen
 */
public class Employee {
    private Profile profile;
    private double payment;

    public Employee(){}

    public Employee(Profile p){ profile = p; }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Profile getProfile(){ return profile; }

    @Override
    public String toString() {
        return profile.toString() + "::Payment $" + String.format("%.2f", payment);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Employee;
    }

    public void calculatePayment(){

    } //(...)
}
