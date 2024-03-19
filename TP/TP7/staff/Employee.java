package staff;
/*
 * This class is the parent class for all employees
 */
public class Employee extends StaffMember{
    protected String socSecNumber;
    protected double payRate;
    
    public Employee(String eName, String eAddress, String ePhone, String socSecNumber, double rate){
        super(eName, eAddress, ePhone);
    }
    
    public double pay() {
        return 0.0;
    }
}
