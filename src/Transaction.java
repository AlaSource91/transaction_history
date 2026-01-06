import java.math.BigDecimal;

public class Transaction implements  Comparable<Transaction>
{
   private   String id;
   private BigDecimal amount;
   private String status; //Success, Failed
   private String date;
   private String userId;

    public Transaction(String id, BigDecimal amount, String status, String date, String userId) {
         this.id = id;
         this.amount = amount;
         this.status = status;
         this.date = date;
         this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public int compareTo(Transaction other) {
        return this.amount.compareTo(other.getAmount());
    }
}
