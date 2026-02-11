package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String OrderId;
    private OrderStatus status;
    private BigDecimal subTotal;
    private BigDecimal discountTotal;
    private BigDecimal shippingCost;
    private BigDecimal total;

    private List<OrderItem> orderItems = new ArrayList();


}
