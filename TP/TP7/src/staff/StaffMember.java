package staff;

/**
 * StaffMember is an abstract class that represents a staff member at a company.
 * It contains basic information such as name, address, and phone number.
 */
public abstract class StaffMember {

    protected String name;
    protected String address;
    protected String phone;

    /**
     * Constructs a StaffMember object with the given name, address, and phone number.
     * Throws an IllegalArgumentException if any of the parameters are null.
     * 
     * @param eName    the name of the staff member
     * @param eAddress the address of the staff member
     * @param ePhone   the phone number of the staff member
     * @throws IllegalArgumentException if any of the parameters are null.
     */
    public StaffMember(String eName, String eAddress, String ePhone) {
        if (eName == null || eAddress == null || ePhone == null) {
            throw new IllegalArgumentException("Les paramètres ne doivent pas être null");
        } 
        else {
            this.name = eName;
            this.address = eAddress;
            this.phone = ePhone;
        }
    }

    /**
     * Returns the string representation of the StaffMember object.
     * 
     * @return the string representation of the StaffMember object
     */
    public String toString() {
        String result = "Nom : " + this.name + "\n";
        result += "Address: " + this.address + "\n";
        result += "Telephone : " + this.phone;
        return result;
    }

    /**
     * Abstract method that calculates and returns the amount to be paid to the staff member.
     * 
     * @return the amount to be paid
     */
    public abstract double pay();

}