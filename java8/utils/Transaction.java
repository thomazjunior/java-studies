package utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Transaction implements RandomPopulatable {
    private String transactionId;
    private double amount;
    private LocalDate date;
    private static final Random random = new Random();

    public Transaction() { };

    public Transaction(String transactionId, double amount, LocalDate date) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{id='" + transactionId + "', amount=$" + amount + ", date=" + date + "}";
    }

    @Override
    public void populateRandomValues() {
        this.transactionId = "TX" + (1000 + random.nextInt(9000));
        this.amount = 100 + random.nextDouble() * 1000;
        this.date = LocalDate.now().minus(random.nextInt(365), ChronoUnit.DAYS);
    }
}
