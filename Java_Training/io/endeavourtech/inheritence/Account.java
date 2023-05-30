package io.endeavourtech.inheritence;

import java.math.BigDecimal;

public class Account {
    private  long accountNumber;
    private BigDecimal balance;



    public Account(long accountNumber, BigDecimal balence) {
        this.accountNumber = accountNumber;
        this.balance = balence;
    }
    public   void debit(BigDecimal amount){
        this.balance = this.balance.subtract(amount);

    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                '}';
    }

    public   void credit(BigDecimal amount){
        this.balance = this.balance.add(amount);

    }
    public BigDecimal getBalence(){
        return this.balance;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }




}
