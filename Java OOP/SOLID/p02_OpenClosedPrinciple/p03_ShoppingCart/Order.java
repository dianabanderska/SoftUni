package p02_OpenClosedPrinciple.p03_ShoppingCart;

public abstract class Order {
    protected final Cart cart;

    protected Order(Cart cart) {
        this.cart = cart;
    }
    void checkout(){
    }
}
