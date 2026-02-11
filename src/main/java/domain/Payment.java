package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private final String transactionId;
    private final PaymentType paymentType;
    private final BigDecimal amount;
    private PaymentStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime paidAt;


    public Payment(BigDecimal amount, PaymentType paymentType) throws InvalidPaymentException{

        if (amount == null) {throw new InvalidPaymentException("Payment amount must be provided.");}

        if (amount.compareTo(BigDecimal.ZERO) > 0){ this.amount = amount; }

        else {throw new InvalidPaymentException("Payment amount must be greater than zero.");}

        if (paymentType == null){throw new InvalidPaymentException("Payment type must be provided.");}

        this.paymentType = paymentType;

        this.transactionId = UUID.randomUUID().toString();

        this.status = PaymentStatus.PENDING;

        this.createdAt = LocalDateTime.now();
    }

    public boolean approve(){
        if (this.status == PaymentStatus.PENDING){
            this.status = PaymentStatus.APPROVED;
            this.paidAt = LocalDateTime.now();
            return true;
        }
        return false;
    }
    public boolean decline(){
        if (this.status == PaymentStatus.PENDING){
            this.status = PaymentStatus.DECLINED;
            return true;
        }
        return false;
    }
    public boolean isApproved(){
        return this.status == PaymentStatus.APPROVED;
    }
    public boolean isPending(){
        return this.status == PaymentStatus.PENDING;
    }

    public boolean isDeclined(){
        return this.status == PaymentStatus.DECLINED;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }
}
