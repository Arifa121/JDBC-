package BusResvDB;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusDemo {  

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		BusDAO busdao=new BusDAO();
		busdao.displayBusinfo();
        

		int userOpt=1;
		Scanner sc=new Scanner(System.in);
		
		while(userOpt==1){
		       System.out.println("Enter 1 to Book and 2 to exit");
		       userOpt= sc.nextInt();
		       if(userOpt==1) {
		    	   Booking booking = new Booking();
		    	   if(booking.isAvailable()) {
		    		   BookingDAO bookingdao=new BookingDAO();
		    		   bookingdao.addBooking(booking);
		    		   System.out.println("Your Booking is confirmed");
		    	   }
		    	   else {
		    		   System.out.println("Sorry. Bus if full. Try another bus or date.");
		    	   }
		    	   
		    }
		
	   }
	  sc.close();	
	}
}
