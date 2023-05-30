import io.endeavourtech.inheritence.Account;

import java.math.BigDecimal;

public class BankTransaction {
    public static void main(String[] args) {
        Account account = new Account(123454, new BigDecimal("100"));
        System.out.println("Balance in account is : " + account.getBalence());

        account.debit(new BigDecimal("50"));
        System.out.println("balance in account is :" + account.getBalence());

        account.credit(new BigDecimal("500"));
        System.out.println("balance in account is :" + account.getBalence());

        CheckingAccount cac= new CheckingAccount( 12349, new BigDecimal("123456"));
        System.out.println("checking account balence is : " + cac.getBalence());

        System.out.println("Checking account toString" + cac.toString());


        cac.debit(new BigDecimal("100"));
        System.out.println("checking account balanec : " + cac.getBalence());

        cac.setOverdraftProtection();

//        cac.credit(new BigDecimal("5000"));
//        System.out.println("checking account after credit total balance is :  "+ cac.getBalence());

        Account checkingAccounts2 = new CheckingAccount(1111, new BigDecimal(200));
//        Casting refer to 22 (casting is needed because checkingAccount2 is "Account type"
        ((CheckingAccount)checkingAccounts2).setOverdraftProtection();
        Account savingAccounts2 = new SavingsAccount(1111, new BigDecimal(200));
        checkingAccounts2.debit(new BigDecimal("100"));
        System.out.println("checking account 2 balance:" + checkingAccounts2.getBalence());

        Account[] accounts = new Account[3];
        accounts[0]= cac;
        accounts[1] = checkingAccounts2;
        accounts[2] = savingAccounts2;

        BigDecimal total = getTotalBalance(accounts);
        System.out.println("total balence of all accounts should be : " + total);

        creatingAccount(true);



//        Account account1 = new Account(123454, new BigDecimal(500));
    }



    private static Account creatingAccount(boolean isCheckingAccount) {
        if(isCheckingAccount){
            return new CheckingAccount(143,new BigDecimal("1000"));
        }else {
            return new SavingsAccount(243,new BigDecimal("2000"));
        }

    }

    private static BigDecimal getTotalBalance(Account[] accounts) {
        BigDecimal total = BigDecimal.ZERO;
        for(Account A : accounts){
            total = total.add(A.getBalence());

        }
        return total;
    }

}
