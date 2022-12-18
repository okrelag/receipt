package by.halerko;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Util {
    static Receipt createReceipt() {
        ReceiptItem receiptItem = new ReceiptItem("apple", 4.5, 4.5, 0, 1);
        List<ReceiptItem> receiptList = List.of(receiptItem);
        Receipt receipt = new Receipt("RandomShop", "12 LindenStreet", "Tel :11-22-445", LocalDateTime.parse("2022-12-18T04:09:51", DateTimeFormatter.ISO_DATE_TIME), receiptList, 4.28, 0.23);
        return receipt;
    }

    static SuperMarket createSuperMarket() {
        return new SuperMarket("RandomShop", "12 LindenStreet", ":11-22-445");
    }

    static ShoppingCart createChoppingCard() {
        Map<Product, Integer> productsMap = Map.of(Product.Builder.builder().setProduct("apple", 1, 4.5).setIsSale(false).build(), 1);
        ShoppingCart shoppingCard = new ShoppingCart(productsMap, new DiscountCard(1, 0));
        return shoppingCard;
    }
}
