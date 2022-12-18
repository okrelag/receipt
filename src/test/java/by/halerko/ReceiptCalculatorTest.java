package by.halerko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ReceiptCalculatorTest {
    @Mock
    private Clock clock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testReceiptCalculator(){
        ReceiptCalculator receiptCalculator = new ReceiptCalculator(clock);
        LocalDateTime localDateTime = LocalDateTime.parse("2022-12-18T04:09:51");
        when(clock.now()).thenReturn(localDateTime);
        Receipt actualReceipt = receiptCalculator.calculate(Util.createSuperMarket(), Util.createChoppingCard());
        Receipt  expectedReceipt  = new Receipt("RandomShop",
                "12 LindenStreet", ":11-22-445",localDateTime
                , List.of(new ReceiptItem("apple", 4.5, 4.5, 0, 1)), 4.5, 0);
        assertEquals(expectedReceipt, actualReceipt);
    }

}