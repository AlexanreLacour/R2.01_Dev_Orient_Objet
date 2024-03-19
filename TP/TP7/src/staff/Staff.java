package staff;

import java.util.ArrayList;

/*
 * Staff
 */
public class Staff {
    private ArrayList<StaffMember> staffList;

    public Staff(){
        staffList = new ArrayList<StaffMember>();
    }

    public void addNewMember(StaffMember member){
        if(member == null){
            System.out.println("Le membre ne doit pas être null");
        }else{
            staffList.add(member);
        }
    }

    public StaffMember getMember(int index){
        StaffMember res = null;
        if(index < 0 || index >= staffList.size()){
            System.out.println("L'index doit être compris entre 0 et " + staffList.size());
            
        }else{
            res = staffList.get(index);
        }
        return res;
    }

    public void payday(){
        System.out.println("---------------------------------------");
        for(int i = 0; i < staffList.size(); i++){
            StaffMember member = getMember(i);
            System.out.println("\tMembre n°"+(i+1));
            System.out.println(member.toString());
            System.out.println("---------------------------------------");
        }
    }
}
