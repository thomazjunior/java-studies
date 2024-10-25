package binaryOperator.transactionExample;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import utils.GenericDataProvider;
import utils.Transaction;

public class TransactionAggregatorExample {
    public static void main(String[] args) {
        // Create a GenericDataProvider for Transaction objects
        GenericDataProvider<Transaction> transactionProvider = new GenericDataProvider<>(Transaction::new);

        // Generate 10 random Transaction instances
        List<Transaction> transactions = transactionProvider.generate(10);

        // Attempt to get a TransactionAggregator of type SUM
        Optional<TransactionAggregator> sumAggregatorOpt = Optional
                .of(TransactionAggregatorFactory.getAggregator("SUM"));

        // Define a Consumer to handle the aggregator when present
        Consumer<TransactionAggregator> aggregatorConsumer = aggregator -> {
            // Use the aggregator to aggregate the transactions
            Transaction result = aggregator.aggregate(transactions);
            // Print the result of the aggregation
            System.out.println("Aggregated Transaction: " + result);
        };

        Runnable emptyAction = () -> {
            // Handle the case where the aggregator is not present
            System.err.println("Error: No aggregator found for type SUM.");
        };

        sumAggregatorOpt.ifPresentOrElse(aggregatorConsumer, emptyAction);
    }
}
