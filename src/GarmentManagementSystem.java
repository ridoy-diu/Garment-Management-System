import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Garment {

    public String id, name, description, size, color;
    public double price;
    public int stockQuantity;

    public void updateStock(int quantity) {
        this.stockQuantity = quantity;

    }

    public double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return discount;
    }
}

class Fabric {

    public String id, type, color;
    public double pricePerMeter;

    public double calculateCost(double meters) {
        double cost = pricePerMeter * meters;
        return cost;
    }
}

class Supplier {

    public String id, name, contactInfo;
    List<Fabric> suppliedFabrics = new ArrayList<>();

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

    public void addGarment(Garment garment) {
        garments.add(garment);
    }

    public double calculateTotalAmount() {
        for (Garment g : garments) {
            totalAmount += g.price;
        }
        return totalAmount;
    }

    public void printOrderDetails() {
        System.out.println("-----Order Details-----");
        for (Garment g : garments) {
            System.out.println("---- ---- ---- ---- ----");
            System.out.println("Name: " + g.name);
            System.out.println("Id: " + g.id);
            System.out.println("Description: " + g.description);
            System.out.println("Size: " + g.size);
            System.out.println("Color: " + g.color);
            System.out.println("Price: " + g.price);
            System.out.println("---- ---- ---- ---- ----");
        }
    }
}

class Customer {

    public String custormeId, name, email, phone;

    public void placeOrder(Order order) {

    }

    public List<Order> viewOrder() {

    }
}


class Inventory {

    public List<Garment> garment;

    public void addGarment(Garment garment) {

    }

    public void removeGarment(String id) {

    }

    public Garment findGarment(String id) {

    }
}

public class GarmentManagementSystem {

    public static void main(String[] args) {

    }
}