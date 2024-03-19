package staff;
/*
 * This class is the parent class for all employees
 */
public class Employee extends StaffMember{
    protected String socSecNumber;
    protected double payRate;
    
    public Employee(String eName, String eAddress, String ePhone, String socSecNumber, double rate){
        super(eName, eAddress, ePhone);
        this.socSecNumber = socSecNumber;
        this.payRate = rate;
    }
    
    public String toString() {
        String result = super.toString();
        result += "\nSocial Security Number: " + socSecNumber;
        return result;
    }

    public double pay() {
        return payRate;
    }
}
