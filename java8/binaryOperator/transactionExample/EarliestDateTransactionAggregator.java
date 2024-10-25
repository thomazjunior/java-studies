package binaryOperator.transactionExample;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BinaryOperator;

import utils.Transaction;

public class EarliestDateTransactionAggregator implements TransactionAggregator {

    BinaryOperator<Transaction> transactionMerger = (tx1, tx2) -> {
        LocalDate earliestDate = tx1.getDate().isBefore(tx2.getDate()) ? tx1.getDate() : tx2.getDate();
        return new Transaction(tx1.getTransactionId(), tx1.getAmount(), earliestDate);
    };

    @Override
    public Transaction aggregate(List<Transaction> transactions) {
        return transactions.stream().reduce(transactionMerger).orElse(null);
    }
}
