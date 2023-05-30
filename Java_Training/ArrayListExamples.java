import io.endeavourtech.inheritence.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArrayListExamples {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        System.out.println("Size of the list is " + stringList.size());
        stringList.add("AAPL");
        System.out.println("size of the list is " + stringList.size());
        stringList.add("MSFT");
        stringList.add("GOOGL");
        stringList.add("TSLA");
        stringList.add("11111");
        System.out.println("List contain AAPL" + stringList.contains("AAPL"));
        System.out.println("MSFT is in the index of " + stringList.indexOf("MSFT"));
//        System.out.println("Removing of the TSLA : "  + stringList.remove("TSLA") );
        System.out.println(stringList +"string list");

//        my own test case
        ArrayListExamples a2 = new ArrayListExamples();
        a2.test();


        for (String i :stringList){
            System.out.println("List element * :" + i);
        }

        List<Account>  accounts= new ArrayList<>();
        Account checkingAccount = new CheckingAccount(1235, new BigDecimal(543));
        Account savingsAccount  = new SavingsAccount(1325, new BigDecimal(312));
        accounts.add(checkingAccount);
        accounts.add(savingsAccount);
       BigDecimal balence =  sumOfBalences(accounts);
        System.out.println(balence);


    }

    private static BigDecimal sumOfBalences(List<Account> accounts) {
        BigDecimal sum = BigDecimal.ZERO;
        for(Account i:accounts){
            sum = sum.add(i.getBalence());

        }
        return sum;





    }

//    private static BigDecimal sumOfBalences(List<Account> accounts) {
//        BigDecimal sum =BigDecimal.ZERO;
//        for(Account account : accounts){
////            sum=sum.add(account.balence);
//            sum = sum.add(account.getBalence());
//            //sum=sum+accountbalance
//        }
//        return sum;

//    }
    private void  test(){
        List<String> tickers = List.of("AAPL" , "MSFT");
//        tickers.add("GOOGL");  // it won't execute because List.of is Immutable
        List<Integer> integers = List.of(1, 2, 4, 5);
        System.out.println(integers+"***");
        System.out.println(tickers+"***");
    }






}
