package binaryOperator.transactionExample;

import java.util.List;

import utils.Transaction;

public interface TransactionAggregator {
    Transaction aggregate(List<Transaction> transaction);
}
