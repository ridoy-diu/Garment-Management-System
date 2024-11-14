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
        Garment g = findGarment(id);
        if (g != null) {
            garments.remove(g);
            System.out.println("Garment removed.");
        } else {
            System.out.println("Garment not found.");
        }
    }

    public Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id.equals(id))
                return g;
        }
        return null;
    }
}

public class GarmentManagementSystem {

    static Inventory inventory = new Inventory();
    static List<Customer> customers = new ArrayList<>();
    static List<Supplier> suppliers = new ArrayList<>();
    static Customer customer;
    static Supplier supplier;
    static Fabric fabric;

    static Customer findCustomer(String id) {
        for (Customer c : customers) {
            if (c.custormeId.equals(id)) {
                return c;
            }
        }
        return null;
    }

    static Order findOrder(String oId) {
        for (Customer c : customers) {
            for (Order o : c.viewOrder()) {
                if (o.OrderID.equals(oId))
                    return o;
            }
        }
        return null;
    }

    static Supplier findSupplier(String sid) {
        for (Supplier s : suppliers) {
            if (s.id.equals(sid)) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu(sc);
        sc.close();
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
            System.out.println("9. Add Fabric by Supplier");
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
                System.out.print("Enter Garment details (name, id, description, size, color, price): ");
                String name = sc.nextLine();
                String id = sc.nextLine();
                String description = sc.nextLine();
                String size = sc.nextLine();
                String color = sc.nextLine();
                double price = sc.nextDouble();

                Garment garment = new Garment(name, id, description, size, color, price);
                inventory.addGarment(garment);
                break;

            case 2:
                System.out.print("Enter Garment ID to remove: ");
                String removingID = sc.nextLine();
                inventory.removeGarment(removingID);
                break;

            case 3:
                System.out.print("Enter Garment ID to find: ");
                String findingID = sc.nextLine();
                Garment g1 = inventory.findGarment(findingID);
                if (g1 != null) {
                    g1.displayDetails();
                } else {
                    System.out.println("Garment not found.");
                }
                break;

            case 4:
                System.out.print("Enter Garment ID to update stock: ");
                String updatingID = sc.nextLine();
                Garment g2 = inventory.findGarment(updatingID);
                if (g2 != null) {
                    System.out.print("Enter stock quantity: ");
                    int quantity = sc.nextInt();
                    g2.updateStock(quantity);
                } else {
                    System.out.println("Garment not found.");
                }
                break;

            case 5:
                System.out.print("Enter Customer ID: ");
                String custormerID = sc.nextLine();
                Customer c = findCustomer(custormerID);
                if (c == null) {
                    System.out.print("You are a new customer. Enter your name, email and phone: ");
                    String customerName = sc.nextLine();
                    String email = sc.nextLine();
                    String phone = sc.nextLine();
                    customer = new Customer(custormerID, customerName, email, phone);
                    customers.add(customer);
                }
                System.out.print("Enter Order ID: ");
                String orderId = sc.nextLine();
                Order order = new Order(orderId, null);
                customer.placeOrder(order);
                break;

            case 6:
                System.out.println("---- All Customer Orders ----");
                for (Customer cu : customers) {
                    System.out.println("Order for custome: " + cu.name);
                    cu.viewOrder();
                }
                break;

            case 7:
                System.out.print("Enter Order ID to calculate total amount: ");
                String orderID = sc.next();
                Order odr = findOrder(orderID);
                if (odr != null) {
                    double total = odr.calculateTotalAmount();
                    System.out.println("Total amount for order " + orderID + ": " + total);
                } else {
                    System.out.println("Order not found.");
                }
                break;

            case 8:
                System.out.print("Enter Garment ID to calculate discount price: ");
                String garmentId = sc.next();
                Garment g = inventory.findGarment(garmentId);
                if (g != null) {
                    System.out.println("Enter discount percentage: ");
                    double discountPercentage = sc.nextDouble();
                    double discountPrice = g.calculateDiscountPrice(discountPercentage);
                    System.out.println("Discounted Price: " + discountPrice);
                } else {
                    System.out.println("Garment not found.");
                }
                break;

            case 9:
                System.out.print("Enter Supplier ID: ");
                String sID = sc.nextLine();
                Supplier s = findSupplier(sID);
                if (s == null) {
                    System.out.println("You are a new supplier.");
                    System.out.print("Enter ID, Name and Contact Info: ");
                    String suppierID = sc.nextLine();
                    String supplierName = sc.nextLine();
                    String contactInfo = sc.nextLine();
                    supplier = new Supplier(suppierID, supplierName, contactInfo);
                }
                System.out.print("Enter Fabric details (id, type, color, price per meter): ");
                String fabricID = sc.nextLine();
                String fabricType = sc.nextLine();
                String fabricColor = sc.nextLine();
                double fabricPricePerMeter = sc.nextDouble();
                fabric = new Fabric(fabricID, fabricType, fabricColor, fabricPricePerMeter);
                supplier.addFabric(fabric);
                System.out.println("Fabric added by suppier.");
                break;

            case 10:
                System.out.print("Enter Supplier ID to view supplied fabrics: ");
                String supplierSearchId = sc.next();
                Supplier sup = findSupplier(supplierSearchId);
                if (sup != null) {
                    sup.getSuppliedFabrics();
                } else {
                    System.out.println("Supplier not found.");
                }
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