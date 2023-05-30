import io.endeavourtech.inheritence.Account;

import java.math.BigDecimal;

public class SavingsAccount extends Account {

    public SavingsAccount(long accountNumber, BigDecimal balence) {
        super(accountNumber, balence);

    }

    @Override
    public void credit(BigDecimal amount) {
        BigDecimal intrestRate=amount.multiply(new BigDecimal("0.02"));
        super.credit(amount);
        super.credit(intrestRate);
    }
}
