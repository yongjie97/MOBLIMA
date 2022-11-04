package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SystemSettings implements Serializable {

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

    public BigDecimal getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(BigDecimal normalPrice) {
        this.normalPrice = normalPrice;
    }

    public BigDecimal getPlatinumPrice() {
        return platinumPrice;
    }

    public void setPlatinumPrice(BigDecimal platinumPrice) {
        this.platinumPrice = platinumPrice;
    }

    public BigDecimal getStudentPrice() {
        return studentPrice;
    }

    public void setStudentPrice(BigDecimal studentPrice) {
        this.studentPrice = studentPrice;
    }

    public BigDecimal getSeniorPrice() {
        return seniorPrice;
    }

    public void setSeniorPrice(BigDecimal seniorPrice) {
        this.seniorPrice = seniorPrice;
    }

    public BigDecimal getCouplePrice() {
        return couplePrice;
    }

    public void setCouplePrice(BigDecimal couplePrice) {
        this.couplePrice = couplePrice;
    }

    public BigDecimal getWeekendIncrement() {
        return weekendIncrement;
    }

    public void setWeekendIncrement(BigDecimal weekendIncrement) {
        this.weekendIncrement = weekendIncrement;
    }

    public BigDecimal getHolidayIncrement() {
        return holidayIncrement;
    }

    public void setHolidayIncrement(BigDecimal holidayIncrement) {
        this.holidayIncrement = holidayIncrement;
    }

    public BigDecimal getBlockbusterIncrement() {
        return blockbusterIncrement;
    }

    public void setBlockbusterIncrement(BigDecimal blockbusterIncrement) {
        this.blockbusterIncrement = blockbusterIncrement;
    }

    public BigDecimal getThreeDIncrement() {
        return threeDIncrement;
    }

    public void setThreeDIncrement(BigDecimal threeDIncrement) {
        this.threeDIncrement = threeDIncrement;
    }

    public BigDecimal getGst() {
        return gst;
    }

    public void setGst(BigDecimal gst) {
        this.gst = gst;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

}
