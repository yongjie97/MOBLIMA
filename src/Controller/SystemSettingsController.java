package Controller;
import Constant.DataFileConstant;
import Entity.systemSettings;
import Repository.systemSettingsRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
public class systemSettingsController {
	private static systemSettingsRespository systemSettingsRepository = new systemSettingsRespository(DataFileConstant.SYSTEMSETTINGS_FILE);
	
	
	public static void addsystemSettings(ArrayList<String> holiday, BigDecimal totalPrice, BigDecimal normalPrice, BigDecimal seniorPrice ,BigDecimal childPrice, BigDecimal platinumPrice, BigDecimal weekendPriceIncrementpercent, BigDecimal holidayPriceIncrement, BigDecimal goodsandServicesTaxpercentforWeekdays)
	{ systemSettings systemSettings = new systemSettings(totalPrice,normalPrice,seniorPrice,childPrice,platinumPrice,weekendPriceIncrementpercent, holidayPriceIncrement,goodsandServicesTaxpercentforWeekdays);
	systemSettings.add(systemSettings);
	}
		

}

