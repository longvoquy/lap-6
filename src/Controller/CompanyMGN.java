package Controller;

//--------------------------------------------------------
import Model.*;
import View.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//--------------------------------------------------------

public class CompanyMGN extends Menu<String> {

    static String[] menu = {"List all Customer", "Add Customer", "Search Customer", "Write data to File", "Delete Customer", "Update Customer", "EXIT (0)"};
    private final Company lib = new Company();
    ValidationUnits val = new ValidationUnits();
    Scanner sc = new Scanner(System.in);
    public CompanyMGN() {
        super("\n----------!!Control System!!----------", menu);
        lib.setCustomerList(lib.loadCustomersFromFile());
    }
//--------------------------------------------------------

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                displayCustomer();
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                searchCustomer();
                break;
            case 4:
                lib.writeCustomersToFile("Customer1.txt");
                break;
            case 5:
                deleteCustomer();
            case 6:
                updateCustomer();
                break;
        }
    }

    //--------------------------------------------------------
    public void displayCustomer() {
        System.out.println("\n==== All Customers ====");
        List<Customer> customers = lib.getCustomerList();
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            customers.forEach(System.out::println);
        }
        int totalCustomers = customers.size();
        System.out.println("Total customers: " + totalCustomers);
    }
    //--------------------------------------------------------
    private void addCustomer() {
        System.out.print("Add New Customer \nEnter Customer ID: ");
        Scanner scanner = new Scanner(System.in);
        String customerID = scanner.nextLine();
        while (!ValidationUnits.isValidCustomerID(customerID)) {
            System.out.print("Invalid format. Enter Customer ID (KH): ");
            customerID = scanner.nextLine();
        }
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone (+09):  ");
        String phone = scanner.nextLine();
        while (!ValidationUnits.isValidPhone(phone)) {
            System.out.print("Invalid format. Enter phone (09-8numbers-): ");
            phone = scanner.nextLine();
        }
        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        String inputDob = scanner.nextLine();
        if (ValidationUnits.isValidDateOfBirth(inputDob)) {
            Customer customer = new Customer(customerID, name, phone, inputDob);
            lib.addCustomer(customer);
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Invalid Date of Birth format.");
        }

    }
    //--------------------------------------------------------
    private void searchCustomer() {
        String[] mSearch = {"Find by CustomerID", "Find by Name", "Find by Phone", "Find by Date", "RETURN (0)"};
        Menu m = new Menu("--Customer Searching--", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        System.out.println("Enter CustomerID");
                        String id = sc.nextLine();
                        ArrayList<Customer> rs = new ArrayList<>();
                        rs = lib.search(s -> s.getIdCustomer().startsWith(id));
                        for (Customer s1 : rs) {
                            System.out.println(s1);
                        }
                        break;
                    case 2:
                        System.out.println("Enter CustomerName");
                        String name = sc.nextLine();
                        rs = new ArrayList<>();
                        rs = lib.search(s -> s.getName().startsWith(name));
                        for (Customer s1 : rs) {
                            System.out.println(s1);
                        }
                        break;

                    case 3:
                        System.out.println("Enter CustomerPhone");
                        String phone = sc.nextLine();
                        rs = new ArrayList<>();
                        rs = lib.search(s -> s.getPhone().startsWith(phone));
                        for (Customer s1 : rs) {
                            System.out.println(s1);
                        }
                        break;
                    case 4:
                        System.out.println("Enter CustomerDate");
                        String dob = sc.nextLine();
                        rs = new ArrayList<>();
                        rs = lib.search(s -> s.getDateOfBirth().startsWith(dob));
                        for (Customer s1 : rs) {
                            System.out.println(s1);
                        }
                        break;
                    default:
                        System.out.println("Return Back");
                        break;
                }
            }
        };
        m.run();

    }
    //--------------------------------------------------------
    private void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        String customerID = scanner.nextLine();
        while (!ValidationUnits.isValidCustomerID(customerID)) {
            System.out.print("Invalid format. Enter Customer ID (KHXX): ");
            customerID = scanner.nextLine();
        }
        lib.deleteCustomer(customerID);
        System.out.println("Customer deleted successfully.");
    }
    //--------------------------------------------------------
    public void updateCustomer() {
        String[] mSearch = {"Update Phone", "Update Date", "Update Phone and Date", "RETURN (0)"};
        Menu m = new Menu("--Customer Update--", mSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        System.out.println("Enter Customer ID:");
                        String id = sc.nextLine();
                        ArrayList<Customer> rs = lib.search(s -> s.getIdCustomer().startsWith(id));
                        for (Customer s1 : rs) {
                            System.out.println(s1);
                        }

                        System.out.println("Enter the new phone number:");
                        String newPhone = sc.nextLine();
                        for (Customer customer : rs) {
                            customer.setPhone(newPhone);
                            System.out.println("Phone number updated for customer with ID: " + customer.getIdCustomer());
                        }
                        break;

                    case 2:
                        System.out.println("Enter Customer ID:");
                        id = sc.nextLine();
                        rs = lib.search(s -> s.getIdCustomer().startsWith(id));
                        for (Customer s1 : rs) {
                            System.out.println(s1);
                        }

                        System.out.println("Enter the new date:");
                        String newDate = sc.nextLine();
                        for (Customer customer : rs) {
                            customer.setDateOfBirth(newDate);
                            System.out.println("Date updated for customer with ID: " + customer.getIdCustomer());
                        }
                        break;

                    case 3:
                        System.out.println("Enter Customer ID:");
                        id = sc.nextLine();
                        rs = lib.search(s -> s.getIdCustomer().startsWith(id));
                        for (Customer s1 : rs) {
                            System.out.println(s1);
                        }

                        System.out.println("Enter the new phone number:");
                        newPhone = sc.nextLine();
                        System.out.println("Enter the new date:");
                        newDate = sc.nextLine();
                        for (Customer customer : rs) {
                            customer.setPhone(newPhone);
                            customer.setDateOfBirth(newDate);
                            System.out.println("Phone number and date updated for customer with ID: " + customer.getIdCustomer());
                        }
                        break;

                    default:
                        System.out.println("Return Back");
                        break;
                }
            }
        };
        m.run();
    }

//--------------------------------------------------------
}





