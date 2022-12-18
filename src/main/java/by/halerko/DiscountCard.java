package by.halerko;

import java.util.Objects;

public class DiscountCard {
    private int id;
    private double discount;

    public DiscountCard(int id, double discount) {

        this.id = id;
        this.discount = discount;
    }



    public double getDiscount() {
        return discount;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return id == that.id && Double.compare(that.discount, discount) == 0;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", discount=" + discount +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discount);
    }
}
