public class TicketMachineScenario {
	static int nbtest = 0, nbok = 0;
    public static void main(String[] args){
        testConstructeur();
        //~ testInsertMoney();
        //~ testPrintTicket();
    }
    
    
    
    public static void testConstructeur(){
		//Test nominal : price > 0
		
		TicketMachine t = new TicketMachine(5);
		if((t.getPrice() == 5) && (t.getBalance() == 0) && (t.getTotal() == 0)){
			System.out.println("Cas nominal : OK");
			nbtest++;
			nbok++;
		}else{
			System.out.println("cas nominal : ERREUR");
			nbtest++;
		}
		
		//Test a la limite : price == 0
		
		TicketMachine t2 = new TicketMachine(0);
		if((t2.getPrice() == 0) && (t2.getBalance() == 0) && (t2.getTotal() == 0)){
			System.out.println("Cas limite : OK");
		}else{
			System.out.println("cas limite : ERREUR");
		}
		
		//Test hors-limite : price < 0
		
		TicketMachine t3 = new TicketMachine(-3);
		if((t3.getPrice() == 0) && (t3.getBalance() == 0) && (t3.getTotal() == 0)){
			System.out.println("Cas hors-limite : OK");
		}else{
			System.out.println("cas hors-limite : ERREUR");
		}		
	}
	
	public static void testInsertMoney(){
		System.out.print("test de InsertMoney");
		
		//Test nominal : amount > 0
		
		TicketMachine t = new TicketMachine(5);
		t.insertMoney(3);
		if ( (t.getBalance() == 3) && (t.getPrice() == 5) && (t.getTotal() == 0) ){
			System.out.println("Cas nominaux : OK");
		}else{
			System.out.println("cas nominaux : ERREUR");
		}
		
		//Test limite : 
		
		
		
		//Test hors-limite :
	}
	
	public static void testPrintTicket(){
		System.out.print("test de testPrintTicket");
		// cas nominal 1 : balance == price
		
		
		
		// cas nominal 2 : balance > price
		
		
		
		// cas hors-limite : balance < price
		
		
		
	}
}
