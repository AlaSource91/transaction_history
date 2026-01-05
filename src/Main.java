import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

          //example Array List
         /**
          * This is an example of how to create and use an ArrayList in Java.
          * is interface is ordered Collection Data and duplicates are allowed.
          *  slow add and remove operations.
          *  quickly access elements by index.
          *  o(1)
          */

        ArrayList arrayList = new ArrayList();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        System.out.println("ArrayList: " + arrayList);

        arrayList.get(1); //Access element at index 1
        System.out.println("Element at index 1: " + arrayList.get(1));


        //Doubly Linked List
        /**
         * This is an example of how to create and use a Doubly Linked List in Java
         * is Fast add and remove operations
         * slow access elements by index
         * o(n)
            */
        List<String> linkedList = new java.util.LinkedList<>();
        linkedList.add("Red");
        linkedList.add("Green");
        linkedList.add("Blue");
        System.out.println("LinkedList: " + linkedList);
        linkedList.remove("Green"); //Remove element "Green"
        System.out.println("After removing 'Green': " + linkedList);

        //Add Transactional History
        /**
         * This is an example of how to create and use Transactional History in Java
         **/
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("T1", new BigDecimal("100.0"), "Success", "2023-10-01", "U1"));
        transactions.add(new Transaction("T2", new BigDecimal("2000.500"), "Failed", "2023-10-05", "U2"));
        transactions.add(new Transaction("T3", new BigDecimal("150.75"), "Success", "2023-10-03", "U3"));
        transactions.add(new Transaction("T4", new BigDecimal("300.00"), "Success", "2023-10-07", "U4"));
        transactions.add(new Transaction("T5", new BigDecimal("50.25"), "Failed", "2023-10-02", "U5"));

        Anlytic_Transaction_History analyzer = new Anlytic_Transaction_History_impl();
        //Successful Transactions
        System.out.println("Successful Transactions: " + analyzer.getTransactionalSuccess(transactions, "Success"));
        //Total Amount Transacted
        System.out.println("Total Amount Transacted: " + analyzer.totalAmountTransacted(transactions));
        //Highest Transaction
        System.out.println("Highest Transaction: " + analyzer.findHighestTransaction(transactions));
        //Check Failed Transactions
        System.out.println("Are there any Failed Transactions? " + analyzer.checkFailedTransactions(transactions, "Failed"));
        //Latest Transaction
        System.out.println("Latest Transaction: " + analyzer.findLatestTransaction(transactions));
    }
}