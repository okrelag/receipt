package by.halerko;

import java.util.Objects;

public class Product {
    private String name;
    private int itemId;
    private double price;
    private boolean isSale = false;

    public Product(String name, int itemId, double price) {
        this.name = name;
        this.itemId = itemId;
        this.price = price;
    }

    private Product(String name, int itemId, double price, boolean isSale) {
        this.name = name;
        this.itemId = itemId;
        this.price = price;
        this.isSale = isSale;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", itemId=" + itemId +
                ", price=" + price +
                ", isSale=" + isSale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return itemId == product.itemId && Double.compare(product.price, price) == 0 && isSale == product.isSale && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, itemId, price, isSale);
    }

    public boolean isSale() {
        return isSale;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getItemId() {
        return itemId;
    }

    public static class Builder {

        private String name;
        private int itemId;
        private double price;
        private boolean isSale = false;

        public static Builder builder() {
            return new Builder();
        }

        public Builder setProduct(String name, int itemId, double price) {
            this.name = name;
            this.itemId = itemId;
            this.price = price;
            return this;
        }

        public Builder setIsSale(boolean isSale) {
            this.isSale = isSale;
            return this;
        }

        public Product build() {

            return new Product(name, itemId, price, isSale);
        }


    }
}
