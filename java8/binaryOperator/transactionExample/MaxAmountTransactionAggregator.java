package binaryOperator.transactionExample;

import java.util.List;
import java.util.function.BinaryOperator;

import utils.Transaction;

public class MaxAmountTransactionAggregator implements TransactionAggregator {

    BinaryOperator<Transaction> merge = (tx1, tx2) -> tx1.getAmount() > tx2.getAmount() ? tx1 : tx2;

    @Override
    public Transaction aggregate(List<Transaction> transactions) {
        return transactions.stream().reduce(merge).orElse(null);
    }
}