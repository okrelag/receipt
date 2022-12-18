package by.halerko;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReceiptCalculator {
    private Clock clock;

    public ReceiptCalculator(Clock clock) {
        this.clock = clock;
    }

    public Receipt calculate(SuperMarket superMarket, ShoppingCart shoppingCart) {
        Map<Product, Integer> products = shoppingCart.getProducts();
        List<ReceiptItem> receiptItems = products.entrySet().stream().map(productAndQuantity -> {
            Product product = productAndQuantity.getKey();
            int quantity = productAndQuantity.getValue();

            double discount = (quantity >= 5 && product.isSale()) ? product.getPrice() * 0.1 : 0;
            return new ReceiptItem(product.getName(), product.getPrice(), (product.getPrice() - discount) * quantity, discount, quantity);
        }).collect(Collectors.toList());

        double priceSum = receiptItems.stream().mapToDouble(receiptItem -> receiptItem.getTotalPrice()).sum();
        DiscountCard discountCard = shoppingCart.getCard();
        double discount = discountCard != null ? priceSum * discountCard.getDiscount() : 0;
        double totalPrice = priceSum - discount;
        return new Receipt(
                superMarket.getName(),
                superMarket.getAddress(),
                superMarket.getPhoneNumber(),
                clock.now(),
                receiptItems, totalPrice,
                discount);


    }

}
