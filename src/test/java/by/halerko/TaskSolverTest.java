package by.halerko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TaskSolverTest {
    private static final String FILE_NAME = "file.txt";
    @Mock
    private KnownItemsReaderFactory knownItemsReaderFactory;
    @Mock
    private ShoppingCartReader shoppingCartReader;
    @Mock
    private ReceiptCalculator receiptCalculator;
    @Mock
    private ConsoleReceiptWriter concoleReceiptWriter;
    @Mock
    private FileReceiptWriter fileReceiptWriter;
    @Mock
    private KnownItemsReader knownItemsReader;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSolver() {
        when(knownItemsReaderFactory.createKnownItemsReader(KnownItemsSource.FILE)).thenReturn(knownItemsReader);
        List<Product> products = List.of(
                Product.Builder.builder().setProduct("apple", 1, 4.5).setIsSale(true).build(),
                Product.Builder.builder().setProduct("banana", 2, 3.4).setIsSale(false).build()
        );
        List<DiscountCard> cards = List.of(new DiscountCard(1234, 0.5), new DiscountCard(1235, 0.05));
        KnownItems knowItems = new KnownItems(products, cards);
        when(knownItemsReader.readKnownItems()).thenReturn(knowItems);
        String[] args = {"ght", "gyr"};
        Map<Product, Integer> productsMap = Map.of(Product.Builder.builder().build(), 2);
        ShoppingCart shoppingCard = new ShoppingCart(productsMap, new DiscountCard(2, 2.2));
        when(shoppingCartReader.readShoppingCart(args, knowItems)).thenReturn(shoppingCard);
        SuperMarket superMarket = new SuperMarket("myMarket", "12 LindenStrasse", "11-22-445");
        Receipt receipt = new Receipt("name", "addr", "2233", LocalDateTime.now(), null, 5.6, 5.6);
        when(receiptCalculator.calculate(superMarket, shoppingCard)).thenReturn(receipt);
        TaskSolver taskSolver = new TaskSolver(knownItemsReaderFactory, shoppingCartReader, receiptCalculator, concoleReceiptWriter, fileReceiptWriter, superMarket);
        taskSolver.solveTask(args);
        verify(concoleReceiptWriter).printCheck(receipt);
        verify(fileReceiptWriter).printToFile(receipt);

    }

}