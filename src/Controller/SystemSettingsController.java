package Controller;
import Constant.DataFileConstant;
import Entity.Systemsettings;
import Repository.SystemsettingsRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
public class SystemsettingsController {
	private static SystemsettingsRespository systemsettingsRepository = new SystemsettingsRespository(DataFileConstant.SYSTEMSETTINGS_FILE);
	
	
	public static void addSystemsettings(ArrayList<String> holiday, BigDecimal totalPrice, BigDecimal normalPrice, BigDecimal seniorPrice ,BigDecimal childPrice, BigDecimal platinumPrice, BigDecimal weekendPriceIncrementpercent, BigDecimal holidayPriceIncrement, BigDecimal goodsandServicesTaxpercentforWeekdays)
	{ Systemsettings Systemsettings = new Systemsettings(totalPrice,normalPrice,seniorPrice,childPrice,platinumPrice,weekendPriceIncrementpercent, holidayPriceIncrement,goodsandServicesTaxpercentforWeekdays);
	Systemsettings.add(Systemsettings);
	}
		

}

