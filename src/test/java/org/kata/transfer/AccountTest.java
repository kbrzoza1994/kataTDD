package org.kata.transfer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AccountTest {
    Account from;
    Account to;

    @Before
    public void setUp() {
        from = new Account(1, new BigDecimal(4512.31));
        to = new Account(2, new BigDecimal(4512.31));
    }

    @Test
    public void CheckIfTransferMoneyChangeBalance() {
        from.TransferMoney(new BigDecimal(454.41), to);

        Assert.assertEquals(from.getBalance(), new BigDecimal(4512.31).subtract(new BigDecimal(454.41)));
        Assert.assertEquals(to.getBalance(), new BigDecimal(4512.31).add(new BigDecimal(454.41)));
    }

    @Test
    public void ReturnFalseWhenAmountToTransferBiggerThanBalance(){
        Assert.assertFalse(from.TransferMoney(new BigDecimal(4545),to));
    }

    @Test
    public void ShouldCreateLogInListOfTransfers(){
        from.TransferMoney(new BigDecimal(454.41), to);

        Assert.assertNotNull(from.getListOfTransactions());
        Assert.assertNotNull(to.getListOfTransactions());
    }

    @Test
    public void shouldNotCreateLogInListOfTransfersWhenTransferFailed(){
        from.TransferMoney(new BigDecimal(4545),to);
        ArrayList arrayList = new ArrayList();

        Assert.assertEquals(from.getListOfTransactions(), arrayList);
        Assert.assertEquals(to.getListOfTransactions(), arrayList);
    }

    @Test
    public void listOfTransactionsShouldHandleCoupleOfOperations(){
        from.TransferMoney(new BigDecimal(452),to);
        from.TransferMoney(new BigDecimal(1111.11),to);
        from.TransferMoney(new BigDecimal(4545),to);
        from.TransferMoney(new BigDecimal(18.44),to);
        to.TransferMoney(new BigDecimal(4545),from);
        to.TransferMoney(new BigDecimal(4545),from);
        to.TransferMoney(new BigDecimal(1.12),from);

        Assert.assertEquals(from.getListOfTransactions().size(), 5);
        Assert.assertEquals(to.getListOfTransactions().size(), 5);

        Assert.assertEquals(from.getListOfTransactions().get(0).getAmount(),to.getListOfTransactions().get(0).getAmount());
        Assert.assertEquals(from.getListOfTransactions().get(4).getAmount(),to.getListOfTransactions().get(4).getAmount());

        Assert.assertEquals(from.getListOfTransactions().get(2).getAmount(), new BigDecimal(18.44));
    }

}
