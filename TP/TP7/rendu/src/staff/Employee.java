package staff;

/**
 * The Employee class is the parent class for all employees.
 * It extends the StaffMember class.
 */
public class Employee extends StaffMember {
    /**
     * The social security number of the employee.
     */
    protected String socSecNumber;
    /**
     * The pay rate of the employee.
     */
    protected double payRate;
    
    /**
     * Constructs an Employee object with the specified name, address, phone number,
     * social security number, and pay rate.
     * 
     * @param eName the name of the employee
     * @param eAddress the address of the employee
     * @param ePhone the phone number of the employee
     * @param socSecNumber the social security number of the employee
     * @param rate the pay rate of the employee
     */
    public Employee(String eName, String eAddress, String ePhone, String socSecNumber, double rate) {
        super(eName, eAddress, ePhone);
        this.socSecNumber = socSecNumber;
        this.payRate = rate;
    }
    
    /**
     * Returns a string representation of the Employee object.
     * 
     * @return a string representation of the Employee object
     */
    public String toString() {
        String result = super.toString();
        result += "\nSocial Security Number: " + this.socSecNumber;
        return result;
    }

    /**
     * Calculates and returns the pay of the employee.
     * 
     * @return the pay of the employee
     */
    public double pay() {
        return this.payRate;
    }
}
