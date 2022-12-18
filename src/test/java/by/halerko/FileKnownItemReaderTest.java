package by.halerko;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

class FileKnownItemReaderTest {
    @Test
    void testFileKnowItemsReader(){
        FileKnownItemReader fileKnownItemReader = new FileKnownItemReader("products1.txt","cards1.txt");
        KnownItems actualKnownItems = fileKnownItemReader.readKnownItems();
        List<Product> products = List.of(
                Product.Builder.builder().setProduct("apple", 1, 4.5).setIsSale(true).build(),
                Product.Builder.builder().setProduct("banana", 2,  3.4).setIsSale(false).build()
        );
        List<DiscountCard> cards = List.of(new DiscountCard(1234 ,0.5), new DiscountCard(1235, 0.05));
        KnownItems expectedKnowItems = new KnownItems(products, cards);
        Assertions.assertEquals(expectedKnowItems, actualKnownItems);


    }
    @Test
    void shouldThrowExceptionOnInvalidNumberFormat(){
        FileKnownItemReader fileKnownItemReader = new FileKnownItemReader("products-invalid.txt","cards1.txt");
        Assertions.assertThrows(NumberFormatException.class, () -> fileKnownItemReader.readKnownItems());
    }
    @Test
    void shouldThrowFileNotFoundFormat(){
        FileKnownItemReader fileKnownItemReader = new FileKnownItemReader("---.txt","cards1.txt");
        Assertions.assertThrows(IllegalArgumentException.class, () -> fileKnownItemReader.readKnownItems());
    }
    @Test
    void shouldThrowFileNotFoundFormat2(){
        FileKnownItemReader fileKnownItemReader = new FileKnownItemReader("products1.txt","cards--1.txt");
        Assertions.assertThrows(IllegalArgumentException.class, () -> fileKnownItemReader.readKnownItems());
    }

}