package staff;
/**
 * StafMember
 */
public abstract class StaffMember {

    protected String name;
    protected String address;
    protected String phone;

    public StaffMember(String eName, String eAddress, String ePhone) {
        if(eName == null || eAddress == null || ePhone == null){
            throw new IllegalArgumentException("Les paramètres ne doivent pas être null");
        }else{
            this.name = eName;
            this.address = eAddress;
            this.phone = ePhone;
        }
    }

    public String toString() {
        String result = "Nom : " + this.name + "\n";
        result += "Address: " + this.address + "\n";
        result += "Telephone : " + this.phone;
        return result;
    }

    public abstract double pay();

}