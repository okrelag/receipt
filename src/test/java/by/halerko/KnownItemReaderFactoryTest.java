package by.halerko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnownItemReaderFactoryTest {
    @Test
    void testFileKnownItemReaderFactory() {
        KnownItemsReaderFactory knownItemsReaderFactory = new KnownItemsReaderFactory();
        KnownItemsReader actualKnowItemReader = knownItemsReaderFactory.createKnownItemsReader(KnownItemsSource.FILE);
        assertTrue(actualKnowItemReader instanceof FileKnownItemReader);
    }
    @Test
    void testRandomItemReaderFactory() {
        KnownItemsReaderFactory knownItemsReaderFactory = new KnownItemsReaderFactory();
        KnownItemsReader actualKnowItemReader = knownItemsReaderFactory.createKnownItemsReader(KnownItemsSource.RANDOM);
        assertTrue(actualKnowItemReader instanceof RandomKnownItemsReader);
    }
    @Test
    void shouldThrowIllegalArgumentException() {
        KnownItemsReaderFactory knownItemsReaderFactory = new KnownItemsReaderFactory();
        Assertions.assertThrows(IllegalArgumentException.class, () -> knownItemsReaderFactory.createKnownItemsReader(null));
    }

}
