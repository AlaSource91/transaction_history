import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Anlytic_Transaction_History_impl  implements  Anlytic_Transaction_History
{
    @Override
    public List<Transaction> getTransactionalSuccess(List<Transaction> transactions, String status) {

        //Predicate to Check Success Status
        Predicate<Transaction> isSuccess = s-> s.getStatus()
                .equalsIgnoreCase("Success");
        //Filter Transactions based on Status
        return transactions
                .stream()
                .filter(isSuccess)
                .toList();
    }

    @Override
    public BigDecimal totalAmountTransacted(List<Transaction> transactions) {

        return transactions
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Transaction findHighestTransaction(List<Transaction> transactions) {
        //Find Transaction withHighest Amount
        return transactions.stream()
                .max(Comparator.comparing(Transaction::getAmount))
                .get();

    }

    @Override
    public Boolean checkFailedTransactions(List<Transaction> transactions, String status) {

        Predicate<String> failedStatus =  s-> s.equalsIgnoreCase(status);

        return transactions
                .stream()
                .anyMatch(t-> failedStatus.test(t.getStatus()));
    }


    @Override
    public Transaction findLatestTransaction(List<Transaction> transactions) {
        // Parse date string to LocalDate for accurate comparison
        return transactions
                .stream()
                .max(Comparator.comparing(t -> LocalDate.parse(t.getDate())))
                .get();
    }
}
