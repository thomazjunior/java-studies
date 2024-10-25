package binaryOperator.transactionExample;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BinaryOperator;

import utils.Transaction;

public class SumTransactionAggregator implements TransactionAggregator {

    BinaryOperator<Transaction> merge = (tx1, tx2) -> {
        double combinedAmount = tx1.getAmount() + tx2.getAmount();
        LocalDate latestDate = tx1.getDate().isAfter(tx2.getDate()) ? tx1.getDate() : tx2.getDate();
        return new Transaction(tx1.getTransactionId(), combinedAmount, latestDate);
    };

    @Override
    public Transaction aggregate(List<Transaction> transactions) {
        return transactions.stream().reduce(merge).orElse(null);
    }
}