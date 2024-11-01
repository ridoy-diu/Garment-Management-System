import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Garment {

    public String id, name, description, size, color;
    public double price;
    public int stockQuantity;

    public void updateStock(int quantity) {

    }

    public double calculateDiscountPrice(double discountPercentage) {
        return discountPercentage;
    }
}

class Fabric {

    public String id, type, color;
    public double pricePerMeter;

    public double calculateCost(double meters) {
        return meters;
    }
}

class Supplier {

    public String id, name, contactInfo;
    List<Fabric> supppliedFabrics;

    public void addFabric(Fabric fabric) {

    }

    public List<Fabric> getSuppliedFabrics() {
        return null;
    }
}

class Order {

    public String OrderID;
    public double totalAmount;
    public Date orderDate;

    public void addGarment(Garment garment) {

    }

    public double calculateTotalAmount() {
        
    }

    public void printOrderDetails() {

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

class Customer {

    public String custormeId, name, email, phone;

    public void placeOrder(Order order) {

    }

    public List<Order> viewOrder() {

    }
}

public class GarmentManagementSystem {

    public static void main(String[] args) {

    }
}