class Main {
    static public void checkout(Customer customer, Cart cart) {
        if (cart.isSufficientBalance(customer.getBalance())) {
            cart.print_cart();
        } else {
            System.out.println("Error: Insufficient balance");
        }

    }

    static public void main(String[] args) {
        System.out.println("\n-----------------------------Testcase 1-----------------------------");

        //Testcase 1
        Cart cart = new Cart();
        Customer customer = new Customer();
        customer.setBalance(100);
        Product cheese = new Product("Cheese", 10, 10, false, true, 100);

        cart.add_to_cart(cheese, 1);
        cart.add_to_cart(cheese, 2);
        checkout(customer, cart);

        System.out.println("-----------------------------Testcase 2-----------------------------");
        //Testcase2
        Cart cart2 = new Cart();
        Customer customer2 = new Customer();
        checkout(customer2, cart2);
        System.out.println("-----------------------------Testcase 3-----------------------------");
        //Testcase2
        Product tv = new Product("TV", 1000, 1, false, true, 1000);
        cart2.add_to_cart(tv, 1);
        checkout(customer2, cart2);
        
    }
}

