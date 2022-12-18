package by.halerko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleReceiptWriterTest {
    @Test
    void testConsoleReceiptWriter(){
        ConcoleReceiptWriter actualConscoleReceiptWriter = new ConcoleReceiptWriter();
        actualConscoleReceiptWriter.printCheck(Util.createReceipt());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream consoleStream = System.out;
        PrintStream stream = new PrintStream(baos);
        System.setOut(stream);
        actualConscoleReceiptWriter.printCheck(Util.createReceipt());
        System.setOut(consoleStream);
        String actualString = baos.toString();
        String excpectedString = """
                                        CASH RECEIPT\s
                                         RandomShop \s
                                        12 LindenStreet \s
                                        Tel :11-22-445 \s
                CASHIER:4444                                DATE: 18/12/2022 \s
                                                             TIME: 04:09:51 \s
                ------------------------------------------------------------
                QTY  DESCRIPTION                     PRICE     SALE    TOTAL\s
                \s
                1    apple                           $4,50    $0,00    $4,50\s
                ------------------------------------------------------------
                DISCOUNT                                               $0,23\s
                TOTAL                                                  $4,28\s        
                    """;
        Assertions.assertEquals(excpectedString.replaceAll("\\r\\n?", "\n"), actualString.replaceAll("\\r\\n?", "\n"));

    }
}
