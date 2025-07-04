class Main {
    static public void checkout(Customer customer, Cart cart) {
        if (cart.isSufficientBalance(customer.getBalance())) {
            cart.print_cart(customer.getBalance());
        } else {
            System.out.println("Error: Insufficient balance");
        }

    }
    static public void main(String[] args) {
        System.out.println("\n-----------------------------Testcase 1-----------------------------");
        Cart cart = new Cart();
        Customer customer = new Customer();
        customer.setBalance(100);
        Product cheese = new Product("Cheese", 10, 10, true, true, 100);
        cart.add_to_cart(cheese, 1);
        cart.add_to_cart(cheese, 2);
        checkout(customer, cart);
        System.out.println();
        System.out.println("-----------------------------Testcase 2 For empty Cart-----------------------------");
        Cart cart2 = new Cart();
        Customer customer2 = new Customer();
        customer2.setBalance(100);
        checkout(customer2, cart2);

        System.out.println();
        System.out.println("-----------------------------Testcase 3 For insufficient balance-----------------------------");
        Product tv = new Product("TV", 1000, 1, false, true, 1000);
        cart2.add_to_cart(tv, 1);
        checkout(customer2, cart2);


        System.out.println("-----------------------------Testcase 4 General Case-----------------------------");
        Cart cart3 = new Cart();
        customer2.setBalance(10000);
        Product tv2 = new Product("TV", 1000, 1, false, true, 10000);
        Product mobile = new Product("Mobile", 1000, 2, false, false);
        Product cheese2 = new Product("Cheese", 10, 10, true, true, 500);
        cart3.add_to_cart(tv2, 1);
        cart3.add_to_cart(mobile, 2);
        cart3.add_to_cart(cheese2, 1);
        checkout(customer2, cart3);
        
    }
}

