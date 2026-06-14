import java.util.ArrayList;
import java.util.List;

public class CManager {
    public List<String> cList = new ArrayList<>();
    public List<String> oList = new ArrayList<>();

    // Adds a customer to the list
    public void aC(String n) {
        cList.add(n);
        System.out.println("Added customer: " + n);
    }

    // Adds an order to the list
    public void aO(String o) {
        oList.add(o);
        System.out.println("Order added: " + o);
    }

    // Processes all orders for a specific customer
    public void pO(String c) {
        System.out.println("Processing orders for: " + c);
        for (int i = 0; i < oList.size(); i++) {
            System.out.println("Processing order: " + oList.get(i));
        }
    }

    // Generates a summary report for customers and orders
    public void gR() {
        System.out.println("Customer Report");
        for (int i = 0; i < cList.size(); i++) {
            System.out.println("Customer: " + cList.get(i));
        }
        System.out.println("Order Report");
        for (int i = 0; i < oList.size(); i++) {
            System.out.println("Order: " + oList.get(i));
        }
    }

    public static void main(String[] args) {
        CManager m = new CManager();
        m.aC("John Doe");
        m.aC("Jane Smith");
        m.aO("Order1");
        m.aO("Order2");
        m.pO("John Doe");
        m.gR();
    }
}