package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long OrderId;
    private OrderStatus status;
    private List<OrderItem> orderItems = new ArrayList();
    private BigDecimal subTotal;
    private BigDecimal discountTotal;
    private BigDecimal shippingCost;
    private BigDecimal total;
}
