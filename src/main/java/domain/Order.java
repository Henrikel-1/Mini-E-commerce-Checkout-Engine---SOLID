package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private OrderStatus status;
    private BigDecimal subtotal;
    private BigDecimal discountTotal;
    private BigDecimal shippingCost;
    private BigDecimal total;
    private LocalDateTime createdAt;

    private List<OrderItem> orderItems;

    public Order(List<OrderItem> orderItems) {

        if (orderItems == null){throw new InvalidOrderException("Order items must be provided.");}

        if (orderItems.isEmpty()){throw new InvalidOrderException("Cannot create an order with no items.");}

        this.status = OrderStatus.CREATED;
        this.orderId = UUID.randomUUID().toString();

        this.orderItems = new ArrayList<>(orderItems); //Criando Cópia para evitar alteração fora do Order.

        this.createdAt = LocalDateTime.now();
        calculateSubTotal();

    }

    private void calculateSubTotal(){
        subtotal = BigDecimal.ZERO;

        for (OrderItem item : orderItems){
            subtotal = subtotal.add(item.getLineTotal());
        }
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }
}
