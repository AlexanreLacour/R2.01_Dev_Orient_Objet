package staff;

/**
 * The Volunteer class represents a staff member who works as a volunteer.
 * It is a subclass of the StaffMember class.
 */
public class Volunteer extends StaffMember{
    
    /**
     * Constructs a Volunteer object with the specified name, address, and phone number.
     * 
     * @param eName    the name of the volunteer
     * @param eAddress the address of the volunteer
     * @param ePhone   the phone number of the volunteer
     */
    public Volunteer(String eName, String eAddress, String ePhone){
        super(eName, eAddress, ePhone);
    }

    /**
     * Calculates the pay for the volunteer.
     * Since volunteers do not receive any payment, the pay is always 0.0.
     * 
     * @return the pay for the volunteer (always 0.0)
     */
    public double pay() {
        return 0.0;
    }
}
