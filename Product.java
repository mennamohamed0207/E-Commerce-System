class Product implements Shipping_Service
{
    String name;
    int price;
    int quantity;
    boolean canExpire;
    boolean isShippable;
    double weight;

    //Following the builder design pattern as the weight doesn't have to exist for the not shippable products
    public Product(String name, int price, int quantity, boolean canExpire, boolean isShippable)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.canExpire = canExpire;
        this.isShippable = isShippable;
    }
    public Product(String name, int price, int quantity, boolean canExpire, boolean isShippable, double weight)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.canExpire = canExpire;
        this.isShippable = isShippable;
        this.weight = weight;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getWeight() {
        return weight;
    }


}