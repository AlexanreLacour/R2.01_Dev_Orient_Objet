
package staff;

import java.util.ArrayList;

/**
 * The Staff class represents a group of staff members.
 */
public class Staff {
    /**
     * The list of staff members.
     */
    private ArrayList<StaffMember> staffList;

    /**
     * Constructs an empty Staff object.
     */
    public Staff(){
        staffList = new ArrayList<StaffMember>();
    }

    /**
     * Adds a new staff member to the staff list.
     * @param member the staff member to be added
     */
    public void addNewMember(StaffMember member){
        if(member == null){
            System.out.println("The member must not be null");
        }else{
            staffList.add(member);
        }
    }

    /**
     * Retrieves the staff member at the specified index.
     * @param index the index of the staff member to retrieve
     * @return the staff member at the specified index, or null if the index is out of range
     */
    public StaffMember getMember(int index){
        StaffMember res = null;
        if(index < 0 || index >= staffList.size()){
            System.out.println("The index must be between 0 and " + staffList.size());
            
        }else{
            res = staffList.get(index);
        }
        return res;
    }

    /**
     * Pays all staff members and prints the payment details.
     */
    public void payday(){
        System.out.println("---------------------------------------");
        for(int i = 0; i < staffList.size(); i++){
            StaffMember member = getMember(i);
            System.out.println("\tMember #" + (i+1));
            System.out.println(member.toString());
            if(member.pay() == 0.00){
                System.out.println("Thanks!");
            }else{
                System.out.println("Payment: $" + member.pay());
            }
            System.out.println("---------------------------------------");
        }
    }
}
