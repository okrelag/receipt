package by.halerko;

import java.util.List;
import java.util.Objects;

public class KnownItems {


    public KnownItems(List<Product> products, List<DiscountCard> cards) {
        this.discountCards = cards;
        this.products = products;
    }

    private List<Product> products;
    private List<DiscountCard> discountCards;
    public List<DiscountCard> getDiscountCards() {
        return discountCards;
    }
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnownItems that = (KnownItems) o;
        return Objects.equals(products, that.products) && Objects.equals(discountCards, that.discountCards);
    }

    @Override
    public String toString() {
        return "KnownItems{" +
                "products=" + products +
                ", discountCards=" + discountCards +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, discountCards);
    }
}
