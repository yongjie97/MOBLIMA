package Controller;
import Constant.DataFileConstant;
import Entity.SystemSettings;

import Repository.SystemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
public class SystemSettingsController {
	private static Repository.SystemRepository SystemRepository = new Repository.SystemRepository(DataFileConstant.SYSTEMSETTINGS_FILE);
	
	
	public static void addsystemSettings(ArrayList<String> holiday, BigDecimal totalPrice, BigDecimal regularPrice, BigDecimal seniorPrice ,BigDecimal childPrice, BigDecimal platinumPrice, BigDecimal weekendPriceIncrementpercent, BigDecimal holidayPriceIncrement, BigDecimal goodsandServicesTaxpercentforWeekdays)
	{ SystemSettings systemSettings = new SystemSettings(totalPrice,regularPrice,seniorPrice,childPrice,platinumPrice,weekendPriceIncrementpercent, holidayPriceIncrement,goodsandServicesTaxpercentforWeekdays);
	systemSettings.add(systemSettings);
	}


	public static char[] getticketPrices(BigDecimal normalPrice, BigDecimal seniorPrice, BigDecimal childPrice,
			BigDecimal platinumPrice, BigDecimal couplePrice) {
		// TODO Auto-generated method stub
		return null;
	}


	public static char[] getweekendPriceIncrementpercent() {
		// TODO Auto-generated method stub
		return null;
	}


	public static char[] getgoodsandServicesTaxpercentforWeekdays() {
		// TODO Auto-generated method stub
		return null;
	}


	public static char[] getholidayPriceIncrement() {
		// TODO Auto-generated method stub
		return null;
	}
		

}
