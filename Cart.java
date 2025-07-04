import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Cart {
    Map<Product, Integer> products = new HashMap<>();
    float shipping_fees = 30;

    public void setShippingFees(int shipping_fees) {
        this.shipping_fees = shipping_fees;
    }

    public float getShippingFees() {
        return shipping_fees;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public boolean isSufficientBalance(float balance) {
        float total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.price * quantity;
        }
        if (total > balance) {
            return false;
        }
        return true;
    }

    public void print_cart(float balance) {
        if (isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }
        System.out.println("** Shipment notice **");
        int total_weight = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (!product.isShippable)
            continue;
            total_weight += product.weight * quantity;
            System.out.printf("%-2s %-10s %10.2f g%n", quantity + "x", product.name, product.weight);

        }
        System.out.println("Total package weight " + total_weight + " g ");
        System.out.println();
        System.out.println("** Checkout receipt **");
        float subtotal = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            subtotal += product.price * quantity;
            System.out.printf("%-2s %-10s %10d%n", quantity + "x", product.name, product.price * quantity);
        }
        float CurrentBalance = balance - (subtotal + shipping_fees);
        System.out.println("----------------------");
        System.out.println("Subtotal         " + subtotal);
        System.out.println("Shipping         " + shipping_fees);
        System.out.println("Amount           " + (subtotal + shipping_fees));
        System.out.println("Current Customer balance  " + CurrentBalance);
        System.out.println();
        send_to_shipping_service();
    }

    public void send_to_shipping_service() {
        List<Shipping_Service> shipping_services = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            if (product.isShippable) {
                product.weight=product.weight * entry.getValue();
                shipping_services.add(product);
                
            }
        }
        for (Shipping_Service shipping_service : shipping_services) {
            System.out.println("Sending " + shipping_service.getName() + " with weight " + shipping_service.getWeight()
                    + " g to shipping service");
        }
    }

    public void add_to_cart(Product product, int quantity) {
        if (product.quantity < quantity) {
            System.out.println("Error: not enough quantity of product: " + product.name);
            return;
        }
        product.quantity -= quantity;
        products.put(product, quantity);
    }

}