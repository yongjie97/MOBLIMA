import Constant.DataFileConstant;
import Entity.SystemSettings;
import Repository.SystemSettingsRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
public class SystemSettingsController {
	private static SystemSettingsRespository systemsettingsRepository = new SystemSettingsRespository(DataFileConstant.SYSTEMSETTINGS_FILE);
	
	
	public static void addSystemsettings(ArrayList<String> holiday, BigDecimal TotalPrice, BigDecimal NormalPrice, java.math.BigDecimal SeniorPrice , java.math.BigDecimal ChildPrice, BigDecimal PlatinumPrice, BigDecimal WeekendPriceIncrementpercent, BigDecimal HolidayPriceIncrement, BigDecimal GoodsandServicesTaxpercentforWeekdays)
	{ Systemsettings SystemSettings = new Systemsettings(TotalPrice,NormalPrice,SeniorPrice,ChildPrice,PlatinumPrice,WeekendPriceIncrementpercent, HolidayPriceIncrement,GoodsandServicesTaxpercentforWeekdays);
	Systemsettings.add(SystemSettings);
	}
		

}

