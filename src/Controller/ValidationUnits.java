package Controller;
//--------------------------------------------------------
import Model.Company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//--------------------------------------------------------
public class ValidationUnits extends Company {

    //--------------------------------------------------------
    public static boolean isValidCustomerID(String customerID) {
        return customerID.matches("KH\\d{2}");
    }

    //--------------------------------------------------------
    public static boolean isValidPhone(String phone) {
        return phone.matches("09\\d{8}");
    }
    //--------------------------------------------------------
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    public static boolean isValidDateOfBirth(String dob) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);  // Ensure strict parsing

        try {
            Date date = sdf.parse(dob);
            return true;  // Date format is valid
        } catch (ParseException e) {
            return false;  // Date format is invalid
        }
    }
//--------------------------------------------------------
}


