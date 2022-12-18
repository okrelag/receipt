package by.halerko;

public class CheckRunner {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("no arguments");
            return;
        }
        String fileName = "C:\\Users\\Sergei\\Desktop\\cash-receipt.txt";
        SuperMarket superMarket = new SuperMarket("RandomShop", "12 LindenStreet", "11-22-445");
        KnownItemsReaderFactory knownItemsReaderFactory = new KnownItemsReaderFactory();
        ShoppingCartReader shoppingCartReader = new ShoppingCartReader();
        ReceiptCalculator receiptCalculator = new ReceiptCalculator(new Clock());
        ConsoleReceiptWriter concoleReceiptWriter = new ConsoleReceiptWriter();
        FileReceiptWriter fileReceiptWriter = new FileReceiptWriter(fileName, concoleReceiptWriter);
        TaskSolver taskSolver = new TaskSolver(knownItemsReaderFactory, shoppingCartReader, receiptCalculator, concoleReceiptWriter, fileReceiptWriter, superMarket);
        taskSolver.solveTask(args);


    }
}
