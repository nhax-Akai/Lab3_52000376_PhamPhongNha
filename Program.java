package Main;


import dao.ManufactureDAO;
import dao.PhoneDAO;
import domain.Manufacture;
import domain.Phone;

public class Program {
    public static void addManufacture() {
        // add 4 manufactures to the database
        ManufactureDAO manufactureDAO = new ManufactureDAO();
        manufactureDAO.add(new Manufacture("1", "Samsung", "Korean", 150, null));
        manufactureDAO.add(new Manufacture("2", "Iphone", "American", 100, null));
        manufactureDAO.add(new Manufacture("3", "Oppo", "Chinese", 200, null));
        manufactureDAO.add(new Manufacture("4", "Vin", "Vietnamese", 300, null));
        // run successfully
    }

    public static void addPhone() {
        // add 4 phones to the database
        PhoneDAO phoneDAO = new PhoneDAO();
        ManufactureDAO manufactureDAO = new ManufactureDAO();
        Manufacture manufacture = manufactureDAO.get("1");
        Manufacture manufacture2 = manufactureDAO.get("2");
        Manufacture manufacture3 = manufactureDAO.get("3");
        phoneDAO.add(new Phone("S1", "Samsung S20 Ultra", 10000000, "black", "Korea", 100, manufacture));
        phoneDAO.add(new Phone("S2", "Oppo Neo 7", 2000000, "white", "Japan", 200, manufacture2));
        phoneDAO.add(new Phone("S3", "Xiaomi 11T", 13000000, "pink", "Chinese", 300, manufacture3));
        phoneDAO.add(new Phone("S4", "Iphone 12", 14000000, "blue", "American", 230, manufacture));

    }

    public static void removePhoneById() {
        PhoneDAO phoneDAO = new PhoneDAO();
        phoneDAO.removeById("S1");
    }

    public static void removeManufactureById() {
        ManufactureDAO manufactureDAO = new ManufactureDAO();
        manufactureDAO.removeById("1");
    }

    public static void updateManufacture() {
        ManufactureDAO manufactureDAO = new ManufactureDAO();
        Manufacture manufacture = manufactureDAO.get("2");
        manufacture.setName("Iphone 14");
        manufactureDAO.update(manufacture);
    }

    public static void updatePhone() {
        PhoneDAO phoneDAO = new PhoneDAO();
        Phone phone = phoneDAO.get("S2");
        phone.setName("Oppo 12");
        phoneDAO.update(phone);
    }

    public static void highestPricePhone() {
        PhoneDAO phoneDAO = new PhoneDAO();
        if (phoneDAO.highestPrice() != null) {
            System.out.println(phoneDAO.highestPrice().getName());
        } else {
            System.out.println("No phone in the database");
        }
    }

    public static void sortByCountry() {
        PhoneDAO phoneDAO = new PhoneDAO();
        // print out the list of phone
        for (Phone phone : phoneDAO.sortPhoneByCountry()) {
            System.out.println(phone.getName());
        }

    }

    public static void checkPhonePrice(String id) {
        // using method checkPhonePrice to check if there is a phone priced above 50
        // million VND
        PhoneDAO phoneDAO = new PhoneDAO();
        if (phoneDAO.checkPhonePrice(id)) {
            System.out.println("There is a phone priced above 50 million VND");
        } else {
            System.out.println("There is no phone priced above 50 million VND");
        }

    }

    public static void getPhoneByColorAndPrice() {
        // using method getPhoneByColorAndPrice to get a list of phones with the color
        PhoneDAO phoneDAO = new PhoneDAO();
        Phone phone = phoneDAO.getPhoneByColorAndPrice();
        if (phone != null) {
            System.out.println(phone.getName());
        } else {
            System.out.println("There is no phone with the color");
        }
    }

    public static void checkManufacturers() {
        ManufactureDAO manufactureDAO = new ManufactureDAO();
        if (manufactureDAO.checkManufacturers()) {
            System.out.println("All manufacturers have more than 100 employees");
        } else {
            System.out.println("Not all manufacturers have more than 100 employees");
        }

    }

    public static void sumOfEmployees() {
        // A method that returns the sum of all employees of the manufactures.
        ManufactureDAO manufactureDAO = new ManufactureDAO();
        System.out.println(manufactureDAO.sumOfEmployees());
    }

    public static void lastUSManufacture() {
        // A method that returns the last US manufacture.
        ManufactureDAO manufactureDAO = new ManufactureDAO();
        Manufacture manufacture = manufactureDAO.lastUSManufacture();
        if (manufacture != null) {
            System.out.println(manufacture.getName());
        } else {
            System.out.println("There is no US manufacture");
        }
    }

    public static void main(String[] args) {
        addManufacture();
        addPhone();
        removePhoneById();
        removeManufactureById();
        updatePhone();
        updateManufacture();
        highestPricePhone();
        sortByCountry();
        checkPhonePrice("S2");
        getPhoneByColorAndPrice();
        checkManufacturers();
        sumOfEmployees();
        lastUSManufacture();

    }
}
