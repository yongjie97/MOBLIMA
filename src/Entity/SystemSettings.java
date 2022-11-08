package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * Class that contains information about system settings for the staff to utilise in the application
 * 
 *
 */
public class SystemSettings implements Serializable {
	/**
	 *  Declaration of variables for system settings class
	 */
    private BigDecimal normalPrice;
    private BigDecimal platinumPrice;
    private BigDecimal studentPrice;
    private BigDecimal seniorPrice;
    private BigDecimal couplePrice;
    private BigDecimal weekendIncrement;
    private BigDecimal holidayIncrement;
    private BigDecimal blockbusterIncrement;
    private BigDecimal threeDIncrement;
    private BigDecimal gst;
    private List<Holiday> holidays;
    /**
     * Constructor for system settings
     */
    public SystemSettings() {
        normalPrice = new BigDecimal(9.50);
        platinumPrice = new BigDecimal(30);
        studentPrice = new BigDecimal(7);
        seniorPrice = new BigDecimal(4);
        couplePrice = new BigDecimal(12);
        weekendIncrement = new BigDecimal(2.50);
        holidayIncrement = new BigDecimal(2.50);
        blockbusterIncrement = new BigDecimal(1);
        threeDIncrement = new BigDecimal(3);
        gst = new BigDecimal(0.07);
        holidays = new ArrayList<>();
    }
    /**
     * Method to get normal price
     * @return normal price of ticket 
     */
    public BigDecimal getNormalPrice() {
        return normalPrice;
    }
    /**
     * Method to set normal price
     * @param normalPrice -BigDecimal
     */
    public void setNormalPrice(BigDecimal normalPrice) {
        this.normalPrice = normalPrice;
    }
    /**
     * Method to get platinum price
     * @return platinum price of ticket
     */
    public BigDecimal getPlatinumPrice() {
        return platinumPrice;
    }
    /**
     * Method to set platinum price
     * @param platinumPrice - BigDecimal
     */
    public void setPlatinumPrice(BigDecimal platinumPrice) {
        this.platinumPrice = platinumPrice;
    }
    /**
     * Method to get student price
     * @return student price of ticket
     */
    public BigDecimal getStudentPrice() {
        return studentPrice;
    }
    /**
     * Method to set student price
     * @param studentPrice - BigDecimal
     */
    public void setStudentPrice(BigDecimal studentPrice) {
        this.studentPrice = studentPrice;
    }
    /**
     * Method to get senior price
     * @return senior price of ticket
     */
    public BigDecimal getSeniorPrice() {
        return seniorPrice;
    }
    /**
     * Method to set senior price
     * @param seniorPrice - BigDecimal
     */
    public void setSeniorPrice(BigDecimal seniorPrice) {
        this.seniorPrice = seniorPrice;
    }
    /**
     * Method to get couple price
     * @return couple price of ticket
     */
    public BigDecimal getCouplePrice() {
        return couplePrice;
    }
    /**
     * Method to set couple price
     * @param couplePrice - BigDecimal
     */
    public void setCouplePrice(BigDecimal couplePrice) {
        this.couplePrice = couplePrice;
    }
    /**
     * Method to get weekend increment
     * @return weekend increment for ticket
     */
    public BigDecimal getWeekendIncrement() {
        return weekendIncrement;
    }
    /**
     * Method to set weekend increment
     * @param weekendIncrement - BigDecimal
     */
    public void setWeekendIncrement(BigDecimal weekendIncrement) {
        this.weekendIncrement = weekendIncrement;
    }
    /**
     * Method to get holiday increment
     * @return holiday increment for ticket
     */
    public BigDecimal getHolidayIncrement() {
        return holidayIncrement;
    }
    /**
     * Method to set holiday increment 
     * @param holidayIncrement - BigDecimal 
     */
    public void setHolidayIncrement(BigDecimal holidayIncrement) {
        this.holidayIncrement = holidayIncrement;
    }
    /**
     * Method to get blockbuster increment
     * @return blockbuster increment for ticket
     */
    public BigDecimal getBlockbusterIncrement() {
        return blockbusterIncrement;
    }
    /**
     * Method to set blockbuster increment
     * @param blockbusterIncrement - BigDecimal
     */
    public void setBlockbusterIncrement(BigDecimal blockbusterIncrement) {
        this.blockbusterIncrement = blockbusterIncrement;
    }
    /**
     *  Method to get three D increment 
     * @return three D increment for ticket
     */
    public BigDecimal getThreeDIncrement() {
        return threeDIncrement;
    }
    /**
     * Method to set three D increment 
     * @param threeDIncrement - BigDecimal
     */
    public void setThreeDIncrement(BigDecimal threeDIncrement) {
        this.threeDIncrement = threeDIncrement;
    }
    /**
     * Method to get GST
     * @return GST for ticket
     */
    public BigDecimal getGst() {
        return gst;
    }
    /**
     * Method to set GST 
     * @param gst - BigDecimal
     */
    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }
    /**
     * Method to get a list of holidays
     * @return information about holidays
     */
    public List<Holiday> getHolidays() {
        return holidays;
    }
    /**
     * Method to set a list of holidays 
     * @param holidays - List<Holiday>
     */
    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

}
