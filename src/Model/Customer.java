package Model;

import java.text.SimpleDateFormat;


public class Customer {
    public String idCustomer;
    public String name;
    public String phone;
    public String dateOfBirth;

    public Customer(String idCustomer, String name, String phone, String dateOfBirth) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {


        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getDateOfBirth() {
//        // change date value to string value
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        return dateFormat.format(dateOfBirth);
//    }

    @Override
    public String toString() {
        return "Customer ID = " + idCustomer + "\tName = " + name + "\tPhone = " + phone + "\t Date Of Birth: " + getDateOfBirth();
    }


}
