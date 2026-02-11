package domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Product{
    private final String id;
    private String name;
    private BigDecimal price;


    public Product(String name, BigDecimal price) {
        if (name == null){throw new InvalidProductException("Product name must be provided.");}

        if (name.isBlank()){throw new InvalidProductException("Product name must not be blank.");}

        if (price == null){throw new InvalidProductException("Product price must be provided.");}

        if (price.compareTo(BigDecimal.ZERO) <= 0){throw new InvalidProductException("Product price must be greater than zero.");}

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
