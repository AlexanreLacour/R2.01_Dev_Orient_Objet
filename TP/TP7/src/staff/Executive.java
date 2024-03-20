/**
 * The `staff` package contains classes related to the staff members of an organization.
 */
package staff;
/**
 * The Executive class represents an executive employee.
 * It is a subclass of the Employee class.
 */
public class Executive extends Employee{
    private double bonus;

    /**
     * Constructs an Executive object with the specified employee details.
     * 
     * @param eName the name of the executive employee
     * @param eAddress the address of the executive employee
     * @param ePhone the phone number of the executive employee
     * @param socSecNumber the social security number of the executive employee
     * @param rate the hourly rate of the executive employee
     */
    public Executive(String eName, String eAddress, String ePhone, String socSecNumber, double rate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.bonus = 0;
    }

    /**
     * Awards a bonus to the executive employee.
     * 
     * @param execBonus the bonus amount to be awarded
     */
    public void awardBonus(double execBonus){
        this.bonus = execBonus;
    }

    /**
     * Calculates and returns the payment for the executive employee.
     * The payment includes the base pay and any bonus amount.
     * 
     * @return the payment for the executive employee
     */
    public double pay() {
        double payment = super.pay() + this.bonus;
        this.bonus = 0;
        return payment;
    }
}
