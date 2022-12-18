package by.halerko;

import java.io.*;
import java.util.ArrayList;

public class FileKnownItemReader implements KnownItemsReader {
    String productsFile;
    String cardsFile;

    public FileKnownItemReader(String productsFile, String cardsFile) {
        this.productsFile = productsFile;
        this.cardsFile = cardsFile;
    }

    private ArrayList<Product> getProductListFromFile(String fileName) throws FileNotFoundException {
        String productName;
        int itemId;
        double price;
        boolean isSale;
        ArrayList<Product> products = new ArrayList<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new FileNotFoundException();
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            while (reader.ready()) {
                String productLine = reader.readLine();
                String[] oneProduct = productLine.trim().split(" ");
                productName = oneProduct[0];
                itemId = Integer.parseInt(oneProduct[1]);
                price = Double.parseDouble(oneProduct[2]);
                if (oneProduct[3].equals("true")) {
                    isSale = true;
                } else {
                    isSale = false;
                }
                Product product = Product.Builder.builder()
                        .setProduct(productName, itemId, price)
                        .setIsSale(isSale)
                        .build();
                products.add(product);
            }
            is.close();
        } catch (NumberFormatException e) {
            System.out.println("неправильные данные в Products file");
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    private ArrayList<DiscountCard> getCardsFromFile(String fileName) throws FileNotFoundException {
        ArrayList<DiscountCard> cards = new ArrayList<>();
        int id;
        double discount;
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new FileNotFoundException();
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            while (reader.ready()) {
                String[] oneCard = reader.readLine().trim().split(" ");
                id = Integer.parseInt(oneCard[0]);
                discount = Double.parseDouble(oneCard[1]);
                cards.add(new DiscountCard(id, discount));
            }
            is.close();
        } catch (NumberFormatException e) {
            System.out.println("неправильные данные в Cards file");
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cards;
    }

    @Override
    public KnownItems readKnownItems() {
        try {
            ArrayList<DiscountCard> cards = getCardsFromFile(cardsFile);
            ArrayList<Product> products = getProductListFromFile(productsFile);
            return new KnownItems(products, cards);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }


    }
}
