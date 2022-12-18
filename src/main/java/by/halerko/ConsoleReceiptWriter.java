package by.halerko;

import java.time.format.DateTimeFormatter;

public class ConsoleReceiptWriter {

    public void printCheck(Receipt receipt) {

        System.out.printf("%36s %n", "CASH RECEIPT");
        System.out.printf("%35s  %n", receipt.getSuperMarketName());
        System.out.printf("%39s  %n", receipt.getSuperMarketAddress());
        System.out.printf("%38s  %n", receipt.getSuperMarketPhoneNumber());
        System.out.print("CASHIER:4444");
        System.out.printf("%48s  %n", "DATE: " + receipt.getPurchaseTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.printf("%59s  %n", "TIME: " + receipt.getPurchaseTime().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-4s %-28s %8s %8s %8s %n %n", "QTY", "DESCRIPTION", "PRICE", "SALE", "TOTAL");
        receipt.getReceiptItems().forEach(this::printReceiptItem);
        System.out.println("------------------------------------------------------------");
        String discount = String.format("%.2f", receipt.getDiscount());
        System.out.printf("%-50s %9s %n", "DISCOUNT", "$" + discount);
        String totalPrice = String.format("%.2f", receipt.getTotalPrice());
        System.out.printf("%-50s %9s %n", "TOTAL", "$" + totalPrice);
    }

    private void printReceiptItem(ReceiptItem receiptItem) {
        String onePositionPrice = String.format("%.2f", receiptItem.getPrice());
        String onePositionSum = String.format("%.2f", receiptItem.getTotalPrice());
        String salePosition = String.format("%.2f", (receiptItem.getDiscount()));
        System.out.printf("%-4d %-28s %8s %8s %8s %n", receiptItem.getQuantity(), receiptItem.getProductName(),
                "$" + onePositionPrice, "$" + salePosition, "$" + onePositionSum);
    }
}
