package by.halerko;

import java.util.Objects;

public class ReceiptItem {
    private String productName;
    private double price;
    private double totalPrice;
    private double discount;
    private int quantity;

    public ReceiptItem(String productName, double price, double totalPrice, double discount, int quantity) {
        this.productName = productName;
        this.price = price;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ReceiptItem{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItem that = (ReceiptItem) o;
        return Double.compare(that.price, price) == 0 && Double.compare(that.totalPrice, totalPrice) == 0 && Double.compare(that.discount, discount) == 0 && quantity == that.quantity && Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price, totalPrice, discount, quantity);
    }
}
