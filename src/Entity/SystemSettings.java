package Entity;

import java.util.ArrayList;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SystemSettings implements Serializable {
	private ArrayList<String> holiday = new ArrayList<String>();
	// to change later to set generic prices first
	private BigDecimal regularPrice = new BigDecimal("13.50");
	private BigDecimal seniorPrice = new BigDecimal("5.00");
	private BigDecimal childPrice = new BigDecimal("7.50");
	private BigDecimal platinumPrice = new BigDecimal("15.00");

	private BigDecimal weekendIncrement = new BigDecimal("0.40");
	private BigDecimal holidayIncrement = new BigDecimal("2.00");
	private BigDecimal gst = new BigDecimal("0.7");
	private BigDecimal totalPrice;
	private BigDecimal weekendPriceIncrementPercent;
	private BigDecimal holidayPriceIncrement;
	private BigDecimal goodsAndServicesTaxPercentForWeekdays;

	public SystemSettings(BigDecimal totalPrice, BigDecimal regularPrice, BigDecimal seniorPrice,
			BigDecimal childPrice, BigDecimal platinumPrice, BigDecimal weekendPriceIncrementPercent,
			BigDecimal holidayPriceIncrement, BigDecimal goodsAndServicesTaxPercentForWeekdays) {
		this.totalPrice = totalPrice;
		this.regularPrice = regularPrice;
		this.seniorPrice = seniorPrice;
		this.childPrice = childPrice;
		this.platinumPrice = platinumPrice;
		this.weekendPriceIncrementPercent= weekendPriceIncrementPercent;
		this.holidayPriceIncrement = holidayPriceIncrement;
		this.goodsAndServicesTaxPercentForWeekdays = goodsAndServicesTaxPercentForWeekdays;
	}

	public BigDecimal getregularPrice() {
		return regularPrice;
	}

	public BigDecimal getseniorPrice() {
		return seniorPrice;
	}

	public BigDecimal getchildPrice() {
		return childPrice;
	}

	public BigDecimal getPlatinumPrice() {
		return platinumPrice;
	}

	public BigDecimal getWeekendPriceIncrementpercent() {
		return weekendIncrement;
	}

	public BigDecimal getHolidayPriceIncrement() {
		return holidayIncrement;
	}

	public BigDecimal getGoodsandServicesTaxpercentforWeekdays() {
		return gst;
	}

	public ArrayList<String> getHoliday() {
		return holiday;
	}

	public void setHoliday(ArrayList<String> holiday) {

	}

	public void setChildPrice(BigDecimal childPrice) {
		this.childPrice = childPrice;
	}

	public void setSeniorPrice(BigDecimal seniorPrice) {
		this.seniorPrice = seniorPrice;
	}

	public void setPlatinumPrice(BigDecimal platinumPrice) {
		this.platinumPrice = platinumPrice;
	}

	public void setWeekendIncrement(BigDecimal price) {
		this.weekendIncrement = price;
	}

	public void setHolidayIncrement(BigDecimal price) {
		this.holidayIncrement = price;
	}

	public void setregularPrice(BigDecimal price) {
		this.regularPrice = price;
	}

	public void setGst(BigDecimal price) {
		this.gst = price;
	}

	public void add(systemSettings systemSettings) {
		// TODO Auto-generated method stub
		
	}
}
