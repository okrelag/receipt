package by.halerko;

import java.util.*;

public class ShoppingCartReader {

    private Map<Product, Integer> yourProducts;
    private DiscountCard yourCard;



    public Map<Product, Integer> getYourProducts() {
        return yourProducts;
    }

    public DiscountCard getYourCard() {
        return yourCard;
    }



    private Product getProduct(int itemId, KnownItems knownItems) throws InvalidInputException {
        Product ourProduct = null;
        List<Product> shopProducts = knownItems.getProducts();

        for (Product product : shopProducts) {
            if (product.getItemId() == itemId) {
                ourProduct = product;
                break;
            }
        }
        if (ourProduct == null) {
            throw new InvalidInputException("товара не существует");
        }
        return ourProduct;
    }

    private DiscountCard getCard(int itemId, KnownItems knownItems) throws InvalidInputException {

        List<DiscountCard> shcpCards = knownItems.getDiscountCards();
        DiscountCard ourCard = null;
        for (DiscountCard discountCard : shcpCards) {
            if (discountCard.getId() == itemId) {
                ourCard = discountCard;
                break;
            }
        }
        if (ourCard == null) {
            throw new InvalidInputException("карты не существует");
        }
        return ourCard;

    }

    private Map<Product, Integer> addYourProducts(String[] ourProductArgs, KnownItems knownItems) throws InvalidInputException {
        Map<Product, Integer> yourProducts = new HashMap<>();
        for (String product : ourProductArgs) {
            String[] productCount = product.split("-");
            try {
                int itemId = Integer.parseInt(productCount[0]);
                int countOfProducts = Integer.parseInt(productCount[1]);
                yourProducts.put(getProduct(itemId, knownItems), countOfProducts);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("товара не существует");
            }
        }
        return yourProducts;

    }

    public ShoppingCart readShoppingCart(String[] args, KnownItems knownItems) throws InvalidInputException {
        if (!this.checkCard(args[args.length - 1])) {
            yourProducts = this.addYourProducts(args, knownItems);

        } else {
            String[] ourProductArgs = Arrays.copyOf(args, args.length - 1);
            yourProducts = this.addYourProducts(ourProductArgs, knownItems);
            String[] cardId = args[args.length - 1].split("-");
            int id = Integer.parseInt(cardId[1]);
            yourCard = this.getCard(id, knownItems);
        }
        return new ShoppingCart(yourProducts, yourCard);

    }

    private boolean checkCard(String card) {
        return card.split("-")[0].equals("card");

    }

}
