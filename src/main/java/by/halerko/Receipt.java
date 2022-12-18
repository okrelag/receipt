package by.halerko;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Receipt {
    private String superMarketName;
    private String superMarketAddress;
    private String superMarketPhoneNumber;
    private LocalDateTime purchaseTime;
    private List<ReceiptItem> receiptItems;
    private double totalPrice;
    private double discount;

    public Receipt(String superMarketName, String superMarketAddress, String superMarketPhoneNumber, LocalDateTime purchaseTime, List<ReceiptItem> receiptItems, double totalPrice, double discount) {
        this.superMarketName = superMarketName;
        this.superMarketAddress = superMarketAddress;
        this.superMarketPhoneNumber = superMarketPhoneNumber;
        this.purchaseTime = purchaseTime;
        this.receiptItems = receiptItems;
        this.totalPrice = totalPrice;
        this.discount = discount;
    }

    public String getSuperMarketName() {
        return superMarketName;
    }

    public String getSuperMarketAddress() {
        return superMarketAddress;
    }

    public String getSuperMarketPhoneNumber() {
        return superMarketPhoneNumber;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public List<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "superMarketName='" + superMarketName + '\'' +
                ", superMarketAddress='" + superMarketAddress + '\'' +
                ", superMarketPhoneNumber='" + superMarketPhoneNumber + '\'' +
                ", purchaseTime=" + purchaseTime +
                ", receiptItems=" + receiptItems +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Double.compare(receipt.totalPrice, totalPrice) == 0 && Double.compare(receipt.discount, discount) == 0 && Objects.equals(superMarketName, receipt.superMarketName) && Objects.equals(superMarketAddress, receipt.superMarketAddress) && Objects.equals(superMarketPhoneNumber, receipt.superMarketPhoneNumber) && Objects.equals(purchaseTime, receipt.purchaseTime) && Objects.equals(receiptItems, receipt.receiptItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(superMarketName, superMarketAddress, superMarketPhoneNumber, purchaseTime, receiptItems, totalPrice, discount);
    }
}
