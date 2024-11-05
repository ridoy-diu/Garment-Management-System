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
    List<Fabric> supppliedFabrics = new ArrayList<>();

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