import io.endeavourtech.inheritence.Account;

import java.math.BigDecimal;

public class CheckingAccount extends Account {

    public CheckingAccount(long accountNumber, BigDecimal balence) {
        super(accountNumber, balence);
    }

    @Override
    public String toString() {
        return "CheckingAccount{}";
    }

    public void setOverdraftProtection(){

    }

//    @Override
//    public void debit(BigDecimal amount) {
//        BigDecimal cashBackAmount = amount.multiply(new BigDecimal("0.05"));
//        super.debit(amount);
//        credit(cashBackAmount);
//
//        }

}

