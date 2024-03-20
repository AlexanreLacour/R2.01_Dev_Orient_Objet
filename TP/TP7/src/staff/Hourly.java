/**
 * The `staff` package contains classes related to the staff members of an organization.
 */
package staff;
/**
 * The Hourly class represents an employee who is paid based on the number of hours worked.
 * It is a subclass of the Employee class.
 */
public class Hourly extends Employee {
    private int hoursWorked;

    /**
     * Constructs a new Hourly object with the specified employee name, address, phone number,
     * social security number, and hourly pay rate.
     *
     * @param eName         the employee's name
     * @param eAddress      the employee's address
     * @param ePhone        the employee's phone number
     * @param socSecNumber  the employee's social security number
     * @param rate          the employee's hourly pay rate
     */
    public Hourly(String eName, String eAddress, String ePhone, String socSecNumber, double rate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.hoursWorked = 0;
    }

    /**
     * Adds the specified number of hours to the total hours worked by the employee.
     *
     * @param moreHours  the number of hours to add
     */
    public void addHours(int moreHours) {
        this.hoursWorked += moreHours;
    }

    /**
     * Calculates and returns the payment for the employee based on the hourly pay rate
     * and the total hours worked. Resets the total hours worked to zero.
     *
     * @return the payment for the employee
     */
    public double pay() {
        double payment;
        payment = payRate * this.hoursWorked;
        this.hoursWorked = 0;
        return payment;
    }

    /**
     * Returns a string representation of the Hourly object, including the employee's information,
     * total hours worked, and salary.
     *
     * @return a string representation of the Hourly object
     */
    public String toString() {
        String result = super.toString();
        result += "\nHours worked: " + this.hoursWorked + "H";
        result += "\nSalary: " + this.pay();
        return result;
    }
}
