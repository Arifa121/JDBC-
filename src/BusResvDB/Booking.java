package BusResvDB; 
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Booking {
	String passengerName;
	int busNo;
    Date date;
    
    Booking(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter passenger name: ");
    	passengerName=sc.next();
    	System.out.println("Enter bus no: ");
    	busNo=sc.nextInt();
    	System.out.println("Enter date dd-mm-yyyy: ");
    	String dateInput= sc.next();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	try {
			date=dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
      //objecti pass panna reference tha pass aagum
    public boolean isAvailable() throws SQLException{
    	
    	
    	BusDAO busdao=new BusDAO();
    	BookingDAO bookingdao=new BookingDAO();
    	int capacity=busdao.getcapacity(busNo);
    	
    	
    	int booked=bookingdao.getbookedcount(busNo,date);
   
    	return booked<capacity?true:false;
    }
}
