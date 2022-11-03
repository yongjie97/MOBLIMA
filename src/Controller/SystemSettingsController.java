package Controller;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import Constant.ApplicationConstant;
import Constant.DataFileConstant;
import Entity.Holiday;
import Entity.SystemSettings;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.SystemSettingsRepository;

public class SystemSettingsController {

    private static SystemSettingsRepository systemSettingsRepository = new SystemSettingsRepository(
            DataFileConstant.SYSTEM_SETTINGS_FILE);

    private static final int ID = 0;

    public static SystemSettings getSystemSettings() {
        if (systemSettingsRepository.size() < 1) {
            systemSettingsRepository.add(new SystemSettings());
        }
        return systemSettingsRepository.get(ID);
    }

    public static String listPrices() {
        SystemSettings systemSettings = getSystemSettings();
        StringBuilder sb = new StringBuilder();
        Locale.setDefault(Locale.US);
        int i = 0;
        sb.append(MessageFormat.format("{0}: {1} - {2,number,currency}\n", ++i, "Normal Price",
                systemSettings.getNormalPrice()));
        sb.append(MessageFormat.format("{0}: {1} - {2,number,currency}\n", ++i, "Platinum Price",
                systemSettings.getPlatinumPrice()));
        sb.append(
                MessageFormat.format("{0}: {1} - {2,number,currency}\n", ++i, "Student Price",
                        systemSettings.getStudentPrice()));
        sb.append(MessageFormat.format("{0}: {1} - {2,number,currency}\n", ++i, "Senior Citizen Price",
                systemSettings.getSeniorPrice()));
        sb.append(MessageFormat.format("{0}: {1} - {2,number,currency}\n", ++i, "Couple Seat Price",
                systemSettings.getCouplePrice()));
        sb.append(MessageFormat.format("{0}: {1} - {2,number,currency}\n", ++i, "Weekend Increment Price",
                systemSettings.getWeekendIncrement()));
        sb.append(MessageFormat.format("{0}: {1} - {2,number,currency}\n", ++i, "Blockbuster Increment Price",
                systemSettings.getBlockbusterIncrement()));
        sb.append(MessageFormat.format("{0}: {1} - {2,number,currency}\n", ++i, "3D Increment Price",
                systemSettings.getThreeDIncrement()));
        sb.append(MessageFormat.format("{0}: {1} - {2,number,currency}\n", ++i, "Holiday Increment Price",
                systemSettings.getHolidayIncrement()));
        sb.append(MessageFormat.format("{0}: {1} - {2,number,percent}", ++i, "GST", systemSettings.getGst()));
        return sb.toString();
    }

    public static void editPrices(int option, double value) throws InvalidInputException {
        option = normaliseId(option);
        SystemSettings systemSettings = getSystemSettings();
        if (value <= 0)
            throw new InvalidInputException("Please enter a valid price.");
        switch (option) {
            case 0:
                systemSettings.setNormalPrice(new BigDecimal(value));
                break;
            case 1:
                systemSettings.setPlatinumPrice(new BigDecimal(value));
                break;
            case 2:
                systemSettings.setStudentPrice(new BigDecimal(value));
                break;
            case 3:
                systemSettings.setSeniorPrice(new BigDecimal(value));
                break;
            case 4:
                systemSettings.setCouplePrice(new BigDecimal(value));
                break;
            case 5:
                systemSettings.setWeekendIncrement(new BigDecimal(value));
                break;
            case 6:
                systemSettings.setBlockbusterIncrement(new BigDecimal(value));
                break;
            case 7:
                systemSettings.setThreeDIncrement(new BigDecimal(value));
                break;
            case 8:
                systemSettings.setHolidayIncrement(new BigDecimal(value));
                break;
            case 9:
                if (value > 1)
                    throw new InvalidInputException("Please enter a valid GST.");
                systemSettings.setGst(new BigDecimal(value));
                break;
            default:
                throw new InvalidInputException("Please enter a valid option.");
        }
        systemSettingsRepository.edit(ID, systemSettings);
    }

    public static void addHoliday(String holidayName, String date) throws InvalidInputException {
        try {
            if (holidayName.isEmpty())
                throw new InvalidInputException("Please enter a holiday name.");
            LocalDate holidayDate = LocalDate.parse(date, dateFormatter());
            SystemSettings systemSettings = systemSettingsRepository.get(ID);
            systemSettings.getHolidays().add(new Holiday(holidayName, holidayDate));
            systemSettingsRepository.edit(ID, systemSettings);
        } catch (DateTimeParseException e) {
            throw new InvalidInputException("Please enter a valid date format.");
        }
    }

    public static void editHoliday(int id, String holidayName, String date)
            throws InvalidInputException, InvalidIdException {
        id = normaliseId(id);

        SystemSettings systemSettings = getSystemSettings();
        if (id < 0 || id >= systemSettings.getHolidays().size())
            throw new InvalidIdException("Please enter a valid holiday id.");

        try {
            LocalDate holidayDate = LocalDate.parse(date, dateFormatter());
            Holiday holiday = new Holiday(holidayName, holidayDate);
            systemSettings.getHolidays().set(id, holiday);
            systemSettingsRepository.edit(ID, systemSettings);
        } catch (DateTimeParseException e) {
            throw new InvalidInputException("Please enter a valid date format.");
        }
    }

    public static void removeHoliday(int id) throws InvalidIdException {
        id = normaliseId(id);

        SystemSettings systemSettings = getSystemSettings();
        if (id < 0 || id >= systemSettings.getHolidays().size())
            throw new InvalidIdException("Please enter a valid holiday id.");

        systemSettings.getHolidays().remove(id);
        systemSettingsRepository.edit(ID, systemSettings);
    }

    public static String listHoliday() throws EmptyListException {
        SystemSettings systemSettings = getSystemSettings();
        if (systemSettings.getHolidays().isEmpty())
            throw new EmptyListException("No holiday found.");

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < systemSettings.getHolidays().size(); i++) {
            output.append(MessageFormat.format("{0}: {1} - {2}\n", i + 1, systemSettings.getHolidays().get(i).getName(),
                    systemSettings.getHolidays().get(i).getDate().format(dateFormatter())));
        }
        return output.substring(0, output.length() - 1).toString();
    }

    private static DateTimeFormatter dateFormatter() {
        return DateTimeFormatter.ofPattern(ApplicationConstant.DATE_FORMAT);
    }

    public static int normaliseId(int id) {
        return id - 1;
    }

}
