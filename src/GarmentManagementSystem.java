import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

class Garment {

    public String name, id, description, size, color;
    public double price;
    public int stockQuantity;

    Garment(String name, String id, String description, String size, String color, double price) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = 0;
    }

    public void updateStock(int quantity) {
        this.stockQuantity = quantity;
    }

    public double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return price - discount;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
        System.out.println("Stock Quantity: " + stockQuantity);
    }
}

class Fabric {

    public String id, type, color;
    public double pricePerMeter;

    Fabric(String id, String type, String color, double pricePerMeter) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }

    public double calculateCost(double meters) {
        double cost = pricePerMeter * meters;
        return cost;
    }
}

class Supplier {

    public String id, name, contactInfo;
    private List<Fabric> suppliedFabrics = new ArrayList<>();

    Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public void addFabric(Fabric fabric) {
        suppliedFabrics.add(fabric);
    }

    public List<Fabric> getSuppliedFabrics() {
        return suppliedFabrics;
    }
}

class Order {

    public String OrderID;
    public double totalAmount;
    public Date orderDate;
    List<Garment> garments = new ArrayList<>();

    Order(String OrderID, Date orderDate) {
        this.OrderID = OrderID;
        this.orderDate = orderDate;
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
    }

    public double calculateTotalAmount() {
        totalAmount = 0;
        for (Garment g : garments) {
            totalAmount += g.price;
        }
        return totalAmount;
    }

    public void printOrderDetails() {
        System.out.println("----- Order Details -----");
        for (Garment g : garments) {
            g.displayDetails();
            System.out.println("----- ------------- -----");
        }
        System.out.println("Total Amount: " + totalAmount);
    }
}

class Customer {

    public String custormeId, name, email, phone;
    List<Order> orders = new ArrayList<>();

    Customer(String customerId, String name, String email, String phone) {
        this.custormeId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order is placed successfully.");
        order.printOrderDetails();
    }

    public List<Order> viewOrder() {
        return orders;
    }
}

class Inventory {

    public List<Garment> garments = new ArrayList<>();

    public void addGarment(Garment garment) {
        garments.add(garment);
        System.out.println("Garment added to inventory.");
    }

    public void removeGarment(String id) {
        garments.remove(id);
    }

    public Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id == id)
                return g;
        }
        System.out.println("Garment not found.");
        return null;
    }
}

public class GarmentManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu(sc);
    }

    static void displayMenu(Scanner sc) {

        int choice;

        do {

            System.out.println("----- Garment Management System -----");
            System.out.println("1. Add Garment to Inventory");
            System.out.println("2. Remove Garment from Inventory");
            System.out.println("3. Find Garment by ID");
            System.out.println("4. Update Garment Stock");
            System.out.println("5. Place New Order");
            System.out.println("6. View All Customer Orders");
            System.out.println("7. Calculate Total Amount of Order");
            System.out.println("8. Calculate Garment Discount Price");
            System.out.println("9. Add Fabric to Supplier");
            System.out.println("10. View Supplier Fabrics");
            System.out.println("11. Exit");
            System.out.println("----- ------------------------- -----");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            performAction(choice, sc);

        } while (choice != 11);

    }

    static void performAction(int choice, Scanner sc) {

        sc.nextLine();

        switch (choice) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            case 11:
                System.out.println("Exiting the system.");
                break;

            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }
}