package by.halerko;

import java.io.*;

public class FileReceiptWriter {



 private  String fileName;
 private ConcoleReceiptWriter concoleReceiptWriter;

    public FileReceiptWriter(String fileName, ConcoleReceiptWriter concoleReceiptWriter) {
        this.fileName = fileName;
        this.concoleReceiptWriter = concoleReceiptWriter;
    }

    public void printToFile(Receipt receipt) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        concoleReceiptWriter.printCheck(receipt);
        System.setOut(consoleStream);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(outputStream.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("incorrect filename");
        }
    }
}
