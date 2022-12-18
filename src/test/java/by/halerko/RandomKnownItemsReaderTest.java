package by.halerko;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomKnownItemsReaderTest {
    @Test
    void testRandomKnownItemsReader(){
        RandomKnownItemsReader randomKnownItemsReader = new RandomKnownItemsReader();
        KnownItems knownItems =  randomKnownItemsReader.readKnownItems();
        List<DiscountCard> cardsList =knownItems.getDiscountCards();
        List<Product> productList = knownItems.getProducts();
        assertNotNull(knownItems);
        assertNotNull(cardsList);
        assertNotNull(productList);
    }


}