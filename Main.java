class Main {
    static public void checkout(Customer customer, Cart cart) {
        if (cart.isSufficientBalance(customer.getBalance())) {
            cart.print_cart();
        } else {
            System.out.println("Error: Insufficient balance");
        }

    }

    static public void main(String[] args) {
        Cart cart = new Cart();
        Customer customer = new Customer();
        customer.setBalance(100);
        Product cheese = new Product("Cheese", 10, 10, false, true, 100);

        cart.add_to_cart(cheese, 1);
        cart.add_to_cart(cheese, 2);
        checkout(customer, cart);
    }
}

