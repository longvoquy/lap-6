package Model;
//-------------------------------------------------------------------------------
import Controller.ValidationUnits;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;

//-------------------------------------------------------------------------------
public class Company {

    static ArrayList<Customer> customerList;

    public Company() {
        this.customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    //-------------------------------------------------------------------------------
    public static void display(ArrayList<Customer> rs) {
    }

    public ArrayList<Customer> search(Object o) {
        return customerList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList.addAll(customerList);
    }
    //-------------------------------------------------------------------------------
    public ArrayList<Customer> loadCustomersFromFile() {
        ArrayList<Customer> cusL = new ArrayList<>();
        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\IDEA_JAVA_PROJECT\\Lap6-new\\Customer.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String customerID = data[0].trim();
                    if (!ValidationUnits.isValidCustomerID(customerID)) {
                        continue;
                    }
                    String name = data[1].trim();
                    String phone = data[2].trim();
                    String dateOfBirth = data[3].trim();
                    Customer customer = new Customer(customerID, name, phone, dateOfBirth);
                    cusL.add(customer);
                }

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cusL;
    }
    //-------------------------------------------------------------------------------
    public void writeCustomersToFile(String fileName) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Customer customer : customerList) {
                writer.write(customer.getIdCustomer() + "," + customer.getName() + "," + customer.getPhone() + "," + customer.getDateOfBirth() + ".");
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //-------------------------------------------------------------------------------
    public void deleteCustomer(String customerID) {
        customerList.removeIf(customer -> customer.getIdCustomer().equals(customerID));
    }
    //-------------------------------------------------------------------------------
    public static ArrayList<Customer> search(Predicate<Customer> p) {
        ArrayList<Customer> rs = new ArrayList<>();
        for (Customer s : customerList) {
            if (p.test(s)) {
                rs.add(s);
            }
        }
        return rs;

    }
    //-------------------------------------------------------------------------------
}

