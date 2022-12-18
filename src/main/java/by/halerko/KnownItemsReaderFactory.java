package by.halerko;

public class KnownItemsReaderFactory {
    private static final String PRODUCTS_FILE_NAME = "products.txt";
    private static final String CARDS_FILE_NAME = "cards.txt";

    public KnownItemsReader createKnownItemsReader(KnownItemsSource knownItemsSource) {
        if (knownItemsSource == KnownItemsSource.FILE) {
            return new FileKnownItemReader(PRODUCTS_FILE_NAME, CARDS_FILE_NAME);
        } else if (knownItemsSource == KnownItemsSource.RANDOM) {
            return new RandomKnownItemsReader();
        } else {
            throw new IllegalArgumentException("unsupported reader source" + knownItemsSource);
        }
    }
}
