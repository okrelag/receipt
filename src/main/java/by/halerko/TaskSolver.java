package by.halerko;

import java.io.FileNotFoundException;

public class TaskSolver {

    private KnownItemsReaderFactory knownItemsReaderFactory;
    private ShoppingCartReader shoppingCartReader;
    private ReceiptCalculator receiptCalculator;
    private ConcoleReceiptWriter concoleReceiptWriter;
    private FileReceiptWriter fileReceiptWriter;
    private SuperMarket superMarket;

    public TaskSolver(KnownItemsReaderFactory knownItemsReaderFactory, ShoppingCartReader shoppingCartReader, ReceiptCalculator receiptCalculator, ConcoleReceiptWriter concoleReceiptWriter, FileReceiptWriter fileReceiptWriter, SuperMarket superMarket) {
        this.knownItemsReaderFactory = knownItemsReaderFactory;
        this.shoppingCartReader = shoppingCartReader;
        this.receiptCalculator = receiptCalculator;
        this.concoleReceiptWriter = concoleReceiptWriter;
        this.fileReceiptWriter = fileReceiptWriter;
        this.superMarket = superMarket;
    }

    public void solveTask(String[] args) {

        ShoppingCart shoppingCart;
        try {
            KnownItemsReader knownItemsReader = knownItemsReaderFactory.createKnownItemsReader(KnownItemsSource.FILE);
            KnownItems knownItems = knownItemsReader.readKnownItems();
            shoppingCart = shoppingCartReader.readShoppingCart(args, knownItems);
        } catch (InvalidInputException e) {
            System.out.println("неправильно введены данные");
            return;
        }

        Receipt receipt = receiptCalculator.calculate(superMarket, shoppingCart);
        concoleReceiptWriter.printCheck(receipt);
        fileReceiptWriter.printToFile(receipt);

    }
}
