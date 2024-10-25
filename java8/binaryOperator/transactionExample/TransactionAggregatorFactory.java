package binaryOperator.transactionExample;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class TransactionAggregatorFactory {
    private static final Map<String, Supplier<TransactionAggregator>> aggregatorMap = new HashMap<>();

    static {
        aggregatorMap.put("SUM", SumTransactionAggregator::new);
        aggregatorMap.put("MAX_AMOUNT", MaxAmountTransactionAggregator::new);
        aggregatorMap.put("EARLIEST_DATE", EarliestDateTransactionAggregator::new);
    }

    public static TransactionAggregator getAggregator(String type) {
        return Optional.ofNullable(aggregatorMap.get(type))
                .map(Supplier::get)
                .orElseThrow(() -> new IllegalArgumentException("No aggregator found for type: " + type));
    }
}
