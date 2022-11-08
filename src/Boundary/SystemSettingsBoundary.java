package Boundary;

import java.util.Scanner;

import Constant.ApplicationConstant;
import Controller.SystemSettingsController;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
/**
 * UI for system settings
 */
public class SystemSettingsBoundary {
	/**
	 * Chooses to manage the holiday and prices
	 * Used by staff
	 */
    public static void manageSystemSettings() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("==  Managing System Settings ==");
                System.out.println("===============================");
                System.out.println("Action List");
                System.out.println("1: Manage Holiday");
                System.out.println("2: Manage Prices");
                System.out.println("Enter -1 to go back");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        SystemSettingsBoundary.manageHoliday();
                        break;
                    case 2:
                        SystemSettingsBoundary.managePrices();
                        break;
                    case -1:
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }
    /**
     * UI choice to add holiday
     * or delete holiday
     */
    public static void manageHoliday() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("==      Managing Holiday     ==");
                System.out.println("===============================");
                SystemSettingsBoundary.listHoliday();
                System.out.println("===============================");
                System.out.println("Action List");
                System.out.println("1: Add Holiday");
                System.out.println("2: Delete Holiday");
                System.out.println("Enter -1 to go back");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        SystemSettingsBoundary.addHoliday();
                        break;
                    case 2:
                        SystemSettingsBoundary.deleteHoliday();
                        break;
                    case -1:
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (userInput != -1);
    }
    /**
     * Adds a holiday
     */
    public static void addHoliday() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter the holiday name: ");
            String name = sc.nextLine().trim();
            System.out.print("Please enter the date (" +
                    ApplicationConstant.DATE_FORMAT + ") to add: ");
            String date = sc.nextLine().trim();
            SystemSettingsController.addHoliday(name, date);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Please enter a valid option.");
        }
    }
    /**
     * Deletes a holiday
     */
    public static void deleteHoliday() {
        Scanner sc = new Scanner(System.in);
        if (SystemSettingsController.getSystemSettings().getHolidays().isEmpty()) {
            System.out.println("No holiday found.");
            System.out.print("Press enter to continue..");
            sc.nextLine();
            return;
        }

        try {
            System.out.print("Please enter a holiday id to delete: ");
            int id = sc.nextInt();
            sc.nextLine();
            SystemSettingsController.removeHoliday(id);
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Please enter a valid option.");
        }
    }
    /**
     * Edits the prices 
     */
    public static void managePrices() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("==      Managing Prices      ==");
                System.out.println("===============================");
                SystemSettingsBoundary.listSystemSetting();
                System.out.println("===============================");
                System.out.print("Please enter a field to edit (-1 to go back): ");
                userInput = sc.nextInt();
                sc.nextLine();
                if (userInput == -1)
                    break;
                System.out.print("Please enter the new value (-1 to stop edit): ");
                double value = sc.nextDouble();
                sc.nextLine();
                if (value != -1)
                    SystemSettingsController.editPrices(userInput, value);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }
    /**
     * Lists the prices set
     */
    public static void listSystemSetting() {
        System.out.println("Prices");
        System.out.println(SystemSettingsController.listPrices());
    }
    /**
     * Lists the holidays
     */
    public static void listHoliday() {
        System.out.println("Holiday");
        try {
            System.out.println(SystemSettingsController.listHoliday());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }

}
