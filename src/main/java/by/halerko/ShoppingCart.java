package by.halerko;

import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> yourProducts;
    private DiscountCard yourCard;

    public ShoppingCart(Map<Product, Integer> yourProducts, DiscountCard yourCard) {
        this.yourProducts = yourProducts;
        this.yourCard = yourCard;
    }

    public Map<Product, Integer> getProducts() {
        return yourProducts;
    }

    public DiscountCard getCard() {
        return yourCard;
    }


}
