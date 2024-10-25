package binaryOperator;

import java.util.function.BinaryOperator;

import utils.DataProvider;
import utils.GenericDataProvider;
import utils.Transaction;

// The @BinaryOperator takes two arguments of the same type and returns a result of the same type of its arguments
public class BinaryOperatorExample {
    public static void main(String[] args) {
        // Create a DataProvider to generate random transactions
        DataProvider<Transaction> transactionProvider = new GenericDataProvider<>(Transaction::new);

        Transaction transaction1 = transactionProvider.generate(1).get(0);
        Transaction transaction2 = transactionProvider.generate(1).get(0);
        System.out.println("Transaction 1: " + transaction1);
        System.out.println("Transaction 2: " + transaction2);
        // Define BinaryOperator to combine transactions
        BinaryOperator<Transaction> combineTransactions = (tx1, tx2) -> {
            Transaction combined = new Transaction();
            combined.populateRandomValues();
            combined.setAmount(tx1.getAmount() + tx2.getAmount());
            combined.setDate(tx1.getDate().isAfter(tx2.getDate()) ? tx1.getDate() : tx2.getDate());
            return combined;
        };

        Transaction combinedTransaction = combineTransactions.apply(transaction1, transaction2);
        System.out.println("Combined Transaction: " + combinedTransaction);
    }
}
