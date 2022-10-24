package sce.SC2002.WWC.first;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class SystemSettings { 
	private static ArrayList<String> holiday = new ArrayList <String>();
	ArrayList<String> s = holiday; 
	public static void main(String[] args) {
	BigDecimal normalPrice = new BigDecimal("13.50");
	BigDecimal seniorPrice = new BigDecimal("5.00");
	BigDecimal childPrice  = new BigDecimal("7.50");
	BigDecimal couplePrice = new BigDecimal("17.00");
	BigDecimal totalPrice = null;
	BigDecimal weekendPriceIncrementpercent =new BigDecimal("0.40");
	BigDecimal holidayPriceIncrement = new BigDecimal("2.00");
	BigDecimal GoodsandServicesTaxpercent= new BigDecimal("0.7");
	int k = 0;
	int saturday=1;
	int sunday=2;
	
	
	
	 while (true) {
	
		 if (holiday != null) {
			totalPrice = normalPrice.add(holidayPriceIncrement);
			totalPrice = seniorPrice.add(holidayPriceIncrement);
			totalPrice = childPrice.add(holidayPriceIncrement);
			totalPrice = couplePrice.add(holidayPriceIncrement);
		 }
		 else {
             if (k<=3) {
			BigDecimal weekendPriceIncrement = normalPrice.multiply(weekendPriceIncrementpercent);
			BigDecimal weekendPriceIncrement2 = couplePrice.multiply(weekendPriceIncrementpercent);
			BigDecimal weekendPriceIncrement3 = seniorPrice.multiply(weekendPriceIncrementpercent);
			BigDecimal weekendPriceIncrement4 = childPrice.multiply(weekendPriceIncrementpercent);

		    weekendPriceIncrement = weekendPriceIncrement.setScale(2, RoundingMode.HALF_UP);
		    weekendPriceIncrement2 = weekendPriceIncrement2.setScale(2, RoundingMode.HALF_UP);
		    weekendPriceIncrement3 = weekendPriceIncrement3.setScale(2, RoundingMode.HALF_UP);
		    weekendPriceIncrement4 = weekendPriceIncrement4.setScale(2, RoundingMode.HALF_UP);

		     totalPrice = normalPrice.add(weekendPriceIncrement);
		     totalPrice = couplePrice.add(weekendPriceIncrement2);
		     totalPrice = seniorPrice.add(weekendPriceIncrement3);
		     totalPrice = childPrice.add(weekendPriceIncrement4);}
             else if (k>=3) {
				 BigDecimal GoodsandServicesTax = normalPrice.multiply(GoodsandServicesTaxpercent);
				 BigDecimal GoodsandServicesTax2 = couplePrice.multiply(GoodsandServicesTaxpercent);
				 BigDecimal GoodsandServicesTax3 = seniorPrice.multiply(GoodsandServicesTaxpercent);
				 BigDecimal GoodsandServicesTax4 = childPrice.multiply(GoodsandServicesTaxpercent);
	             
				GoodsandServicesTax = GoodsandServicesTax.setScale(2, RoundingMode.HALF_UP);
				  
				GoodsandServicesTax2 = GoodsandServicesTax2.setScale(2, RoundingMode.HALF_UP);
				  
				GoodsandServicesTax3 = GoodsandServicesTax3.setScale(2, RoundingMode.HALF_UP);
				  
				GoodsandServicesTax4 = GoodsandServicesTax4.setScale(2, RoundingMode.HALF_UP);
		     
				 totalPrice = normalPrice.add(GoodsandServicesTax);
			     totalPrice = couplePrice.add(GoodsandServicesTax2);
			     totalPrice = seniorPrice.add(GoodsandServicesTax3);
			     totalPrice = childPrice.add(GoodsandServicesTax4);
             }
		 }
	 }

	}


public static ArrayList<String> getHoliday() {
	
		return holiday;
		
	

}
}