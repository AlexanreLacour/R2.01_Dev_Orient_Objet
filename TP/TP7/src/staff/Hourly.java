package staff;
/*
 * Hourly
 */
public class Hourly extends Employee{
    private int hoursWorked;

    public Hourly(String eName, String eAddress, String ePhone, String socSecNumber, double rate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.hoursWorked = 0;
    }

    public void addHours(int moreHours){
        this.hoursWorked += moreHours;
    }

    public double pay() {
        double payment;
        payment = payRate * this.hoursWorked;
        this.hoursWorked = 0;
        return payment;
    }

    public String toString() {
        String result = super.toString();
        result += "\nHeure(s) de travail : " + this.hoursWorked + "H";
        return result;
    }
}
