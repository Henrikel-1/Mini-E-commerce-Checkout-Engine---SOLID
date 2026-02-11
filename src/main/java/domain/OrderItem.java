package domain;

import java.math.BigDecimal;

public class OrderItem {
    private String productId;
    private String productName;
    private BigDecimal unitPrice;
    private int quantity;

    public OrderItem(Product product, int quantity) {

        if (quantity <= 0) {throw new InvalidOrderItemException("Quantity must be greater than zero.");}

        if (product == null){throw new InvalidOrderItemException("Product must be provided.");}

        this.productId = product.getId();
        this.productName = product.getName();
        this.unitPrice = product.getPrice();
        this.quantity = quantity;
    }
    public BigDecimal getLineTotal(){
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
