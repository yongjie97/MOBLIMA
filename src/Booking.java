package sce.SC2002.WWC.first;

	import java.util.Scanner;
	import java.io.PrintStream;
	import java.math.BigDecimal;
	import java.util.UUID;
	

	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;  


	public class Booking {
			public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);{
				String s  = "TransactionID : ";
				BigDecimal  totalPrice=null;
				BigDecimal normalPrice = new BigDecimal("13.50");
				BigDecimal seniorPrice = new BigDecimal("5.00");
				BigDecimal childPrice  = new BigDecimal("7.50");
				BigDecimal couplePrice = new BigDecimal("17.00");
				LocalDateTime DateTime = LocalDateTime.now();  
		        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		        String formatDateTime = DateTime.format(format);  
				String bookingDate = formatDateTime;
				String ShowTime;
			    Object user;
			    
				int[] SeatNo = new int [56];
				int[] SeatforCouples= new int [12];
				int SeatsforCouples = 1;
				int Seats;
				String Name = null;
				user= Name;
				
				
			
				
			
				while (true) {
					System.out.print("Welcome to MOvie Booking and LIsting Management Application(MOBLIMA)\n What is your name?\n");
					Name= sc.nextLine();
					 System.out.println();
					 System.out.println("What is your age?");
				        int age = sc.nextInt();
				        System.out.println("Do you want a couple seat?(Type 1 = Yes; Type 2 = No)");
				        int YesorNo = sc.nextInt();
				        System.out.println("What is the time of the movie?(in 24-hour format)");
				         double showTime = sc.nextFloat();
				        System.out.println("What is the name of the movie?");
				        String movie = sc.next();
					System.out.printf("Welcome %s! Please take a look at the seating plan.\n\n", Name);
					for (int i=1; i<= 40; i++) {
						System.out.print("-");
					}
					System.out.println();
					
					System.out.print(" CINEMA SEATING LAYOUT");
					System.out.println();
					
					for (int j =1; j<=40; j ++) {
						System.out.print("-");
					}
					System.out.println();
					
					for (int j = 1; j <= 40; j++) {
				        System.out.print("-");
				      }
				      System.out.println();
	                  
				      for (int SeatCounter = 1; SeatCounter < SeatNo.length; SeatCounter++) {
				        System.out.printf(SeatCounter + "\t");

				        if( (SeatCounter) % 11 == 0 )
				        	System.out.println();
				      }
				      System.out.println();
				      System.out.print("Couple Seats");
				      System.out.println();
				      
				for (int SeatCounter1 = 1; SeatCounter1 < SeatforCouples.length;SeatCounter1++) {
					System.out.printf(SeatCounter1 + "\t");
					   if( (SeatCounter1) % 11 == 0 )
				        	System.out.println();
					
				}
				 System.out.println();
				 
				for (int k =1; k<=40; k ++) {
					System.out.print("-");
				}
				System.out.println();
			      System.out.print("Which seat would you like to book? ");
			      Seats = sc.nextInt();

			      while (Seats < 0 || Seats > 55) {
			        System.out.println("Only Seats 1 to 55 are allowed to be booked. Please try again: ");
			        Seats = sc.nextInt();
			      }
			      System.out.println("For One Person Only:");
				        if (age < 12) { 
				            totalPrice = childPrice;
				        System.out.println("You are under 12." + "Your price is: " + totalPrice);}
				        
			
				        else {
				        	if (age >= 12 && age <= 65) {
				            totalPrice = normalPrice;
				                System.out.println("Your price is SGD " + totalPrice);}
				                else if (age >65) {
				            totalPrice = seniorPrice;
				                 System.out.println("You are over 65. Your price is SGD " + totalPrice);}}
				        	
				        System.out.println("For Couple:");
				      if (YesorNo < 2 ){
				       totalPrice = couplePrice;
				       System.out.println("Your price is SGD " + totalPrice);}
				      else {
				              if(YesorNo>=2) {
				    		  System.out.println("Not Applicable");}
				      }
				    	  
				
				
				    
				     
				        for (int SeatCounter = 0; SeatCounter < SeatNo.length; SeatCounter++) {
					        if (SeatCounter == Seats) {
					          System.out.println("Seat " + Seats + " is successfully booked.");}
				        }
				        
				        UUID TransactionID =UUID.randomUUID();    
				        
				        
				        
				     
				    	  
				        System.out.printf("ShowTime : "+"%.2f"+"HRS",showTime);
				        System.out.println();
				        System.out.println("Movie Title : " + movie);
				        System.out.println("Name : " + Name);
				        System.out.println("Booking Date and Timing : " + bookingDate);
				        System.out.println(s + TransactionID); 
				        System.out.println("Thanks for Booking with Us!");
				        
			}
				
			}
			}
	}



