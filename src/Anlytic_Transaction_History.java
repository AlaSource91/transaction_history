import java.math.BigDecimal;
import java.util.List;

public interface Anlytic_Transaction_History {

     List<Transaction> getTransactionalSuccess(List<Transaction> transactions, String status);
     BigDecimal totalAmountTransacted(List<Transaction> transactions);
     Transaction findHighestTransaction(List<Transaction>  transactions);
     Boolean checkFailedTransactions( List<Transaction> transactions,String status);
     Transaction findLatestTransaction(List<Transaction> transactions);

}
