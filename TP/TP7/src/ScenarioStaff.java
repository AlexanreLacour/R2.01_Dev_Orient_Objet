import staff.*;

/**
 * The `ScenarioStaff` class is a test class that demonstrates the usage of the `Staff` class.
 * It contains a `main` method that calls the `testStaff` method to perform the test.
 */
public class ScenarioStaff {

    /**
     * The `main` method is the entry point of the program.
     * It calls the `testStaff` method to perform the test.
     * 
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        testStaff();
    }

    /**
     * The `testStaff` method creates a `Staff` object and adds different types of staff members to it.
     * It then calls the `payday` method to calculate and display the payments for the staff members.
     */
    public static void testStaff(){
        System.out.println("#########################");
        System.out.println("Test de la class Staff :");
        System.out.println("#########################");
        System.out.println("");

        Staff staff = new Staff();
        Hourly h1 = new Hourly("Lisa", "21 blv. Panamero Street", "555-1256", "456-789-1234", 50.0);
        h1.addHours(40);
        staff.addNewMember(h1);
        Hourly h2 = new Hourly("Paul", "21 blv. Panamero Street", "555-1256", "456-789-1234", 50.0);
        h2.addHours(40);
        staff.addNewMember(h2);
        Executive e1 = new Executive("Lisa", "21 blv. Panamero Street", "555-1256", "456-789-1234", 1500.0);
        staff.addNewMember(e1);
        Volunteer v1 = new Volunteer("Lisa", "21 blv. Panamero Street", "555-1256");
        staff.addNewMember(v1);

        staff.payday();
        

    }


}
