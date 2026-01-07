import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        //Set Interface and Implementation
        /**
         * This is an example of how to create and use Set Interface and Implementation in Java
         * is unordered Collection Data and duplicates are not allowed.
         **/

        List<String> list = new ArrayList<>();
        list.add("Dog");
        list.add("Cat");
        list.add("Dog"); //Duplicate element
        System.out.println("List: " + list);

        Set<String> convertListToSet = new HashSet<>(list);

        System.out.println("Set (after converting from List): " + convertListToSet);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        //Using Stream to filter even numbers
        Set<Integer> evenNumbers =  numbers
                .stream()
                .filter(isEven)
                .collect(Collectors.toSet());

        System.out.println("Even Numbers Set: " + evenNumbers);

        //Tree Set Implementation
        /**
         * This is an example of how to create and use Tree Set Implementation in Java
         * is ordered Collection Data in ascending order and duplicates are not allowed.
         **/


        Set<Integer> sortedNumbers = new TreeSet<>();
        sortedNumbers.add(5);
        sortedNumbers.add(2);
        sortedNumbers.add(8);
        sortedNumbers.add(1);
        sortedNumbers.add(3);

        System.out.println("TreeSet (Sorted Numbers): " + sortedNumbers);

         //Custom Example
        Set<Transaction> amount = new TreeSet<>(transactions);
         System.out.println("TreeSet (Sorted Transactions by Amount): " + amount);

        //Map Interface and Implementation
        /**
         * This is an example of how to create and use Map Interface and Implementation in Java
         * is unordered Collection Data and stores data in key-value pairs.
         **/
        Map<String,Integer>  nameAgeMap  = new HashMap<>();
        nameAgeMap.put("Alice",30);
        nameAgeMap.put("Bob",25);
        nameAgeMap.put("Alice",35);
        System.out.println("Map (Name to Age): " + nameAgeMap);


      Map<String,Integer>  numbersMap = new HashMap<>();
      numbersMap.put("one",1) ;
      numbersMap.put("two",2) ;
      numbersMap.put("three",3) ;
      numbersMap.put("four",4) ;
      numbersMap.put("five",5) ;

      System.out.println("Map (Numbers): " + numbersMap);
      System.out.println("Key Map  :" + numbersMap.keySet());
      System.out.println("Values Map  :" + numbersMap.values());
      System.out.println("Entry Key Set :" + numbersMap.entrySet());

    Map<String,Integer> numbersEven =   numbersMap.entrySet().stream()
              .filter(n-> n.getValue() % 2 == 0)
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    System.out.println("Even Numbers Map  :" + numbersEven);

    for (Map.Entry<String, Integer> entry : numbersMap.entrySet())
    {
        System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
    }


       enum  Size{
           SMALL,MEDIUM,LARGE,EXTRA_LARGE
       }
           EnumMap<Size,Integer>    enumMap = new EnumMap<>(Size.class) ;
              enumMap.put(Size.SMALL,1);
              enumMap.put(Size.MEDIUM,2) ;
              enumMap.put(Size.LARGE,3) ;
              enumMap.put(Size.EXTRA_LARGE,4) ;

                System.out.println("Enum Map : " + enumMap);
                System.out.println("Enum Map keys : " +  enumMap.keySet());
                System.out.println("Enum Map values : " +  enumMap.values());
                System.out.println("Enum Map entrySet : " +  enumMap.entrySet());
                //Managing Student
              List<String>  students = new ArrayList<>();
              students.add("John");
              students.add("Alice");
              students.add("Bob");
              students.add("Diana");
              for (String student : students)
              {
                  System.out.println("Student Name :   " + student);
              }

              //Remove Duplicate Student Name Using Set
            Set<String>  uniqueStudent = new HashSet<>(students);
            System.out.println("Unique Student Names : " + uniqueStudent);
            Set<String> tags  = new HashSet<>();
            tags.add("Java");
            tags.add("Programming");
            tags.add("Collections");
            if (tags.contains("Paython"))
            {
                System.out.println("Tag Found");
            } else {
                System.out.println("Tag Not Found");
            }
            //Student Grades with Map

          Map<String,Integer>  gradeMap = new HashMap<>();
          gradeMap.put("John",85);
          gradeMap.put("Alice",90);
          gradeMap.put("Bob",78);
          gradeMap.put("Diana",92);

          for (Map.Entry<String,Integer>  entry : gradeMap.entrySet())
          {
              System.out.println("Student: " + entry.getKey() + ", Grade: " + entry.getValue());
          }

          double avg = gradeMap.values()
                  .stream()
                  .mapToDouble( Integer::doubleValue)
                  .average()
                  .getAsDouble();
        System.out.println("Average Grade: " + avg);

        PriorityQueue<Task>    tasks = new PriorityQueue<>();
        tasks.add(new Task("Task 1",2));
        tasks.add(new Task("Task 2",1));
        tasks.add(new Task("Task 3",3));

        while (!tasks.isEmpty()) {
            System.out.println("Processing " + tasks.poll());

        }

        Map<String,String>   linkMap = new LinkedHashMap<>();
        linkMap.put("Google","https://www.google.com");
        linkMap.put("Facebook","https://www.facebook.com");
        linkMap.put("Twitter","https://www.twitter.com");
        System.out.println("LinkedHashMap: " + linkMap);
        for (Map.Entry<String,String> entry : linkMap.entrySet()){

              System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }



    }
    }



