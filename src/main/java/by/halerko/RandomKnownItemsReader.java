package by.halerko;

import java.util.ArrayList;
import java.util.List;

public class RandomKnownItemsReader implements KnownItemsReader {

    public static final double BASE_PRICE = 2.45;
    public static final double BASE_DISCOUNT = 0.1;
    public static final int ITEMS_COUNT = 10;
    public static final int INITIAL_CARD_ID = 1000;

    @Override
    public KnownItems readKnownItems() {
        return new KnownItems(createProductList(), createCardsList());
    }

    private List<Product> createProductList() {
        List<Product> products1 = new ArrayList<>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            products1.add(new Product(("Prod" + i), i, BASE_PRICE + i + Math.random()));

        }

        return products1;
    }

    private List<DiscountCard> createCardsList() {
        List<DiscountCard> cards1 = new ArrayList<>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            cards1.add(new DiscountCard((INITIAL_CARD_ID + i), BASE_DISCOUNT * Math.random()));
        }
        return cards1;
    }
}
