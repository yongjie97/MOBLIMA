package sce.SC2002.WWC.first;

import java.util.ArrayList;
	import java.math.BigDecimal;
	public class Systemsettings { 
		private static ArrayList<String> holiday = new ArrayList <String>();
		ArrayList<String> s = holiday;
		BigDecimal  TotalPrice=null;
		BigDecimal NormalPrice = new BigDecimal("13.50");
		BigDecimal SeniorPrice = new BigDecimal("5.00");
		BigDecimal ChildPrice  = new BigDecimal("7.50");
		BigDecimal PlatinumPrice = new BigDecimal("15.00");
		
		 
            BigDecimal WeekendPriceIncrementpercent =new BigDecimal("0.40");
	    BigDecimal HolidayPriceIncrement = new BigDecimal("2.00");
	    BigDecimal GoodsandServicesTaxpercentforWeekdays= new BigDecimal("0.7");
	    
	    public Systemsettings (BigDecimal TotalPrice, BigDecimal NormalPrice,BigDecimal SeniorPrice, BigDecimal ChildPrice, BigDecimal PlatinumPrice, BigDecimal WeekendPriceIncrementpercent, BigDecimal HolidayPriceIncrement, BigDecimal GoodsandServicesTaxpercentforWeekdays) {
			this.TotalPrice = TotalPrice;
			this.NormalPrice = NormalPrice;
			this.SeniorPrice = SeniorPrice;
			this.ChildPrice = ChildPrice;
			this.PlatinumPrice = PlatinumPrice;
			this.WeekendPriceIncrementpercent = WeekendPriceIncrementpercent;
			this.HolidayPriceIncrement = HolidayPriceIncrement;
			this.GoodsandServicesTaxpercentforWeekdays = GoodsandServicesTaxpercentforWeekdays; 
		}
		
		public BigDecimal getTotalPrice() {
			return TotalPrice;
		}
		public BigDecimal getNormalPrice() {
			return NormalPrice;
		}
		public BigDecimal getSeniorPrice() {
			return SeniorPrice;
		}
		public BigDecimal getChildPrice() {
			return ChildPrice;
		}
		public BigDecimal getPlatinumPrice() {
			return PlatinumPrice;
		}
		public BigDecimal getWeekendPriceIncrementpercent() {
			return WeekendPriceIncrementpercent;
		}
		public BigDecimal getHolidayPriceIncrement() {
			return HolidayPriceIncrement;
		}
		public BigDecimal getGoodsandServicesTaxpercentforWeekdays() {
			return GoodsandServicesTaxpercentforWeekdays;
		}
                public static ArrayList<String> getHoliday() {
	
		return holiday;
		}
	

}