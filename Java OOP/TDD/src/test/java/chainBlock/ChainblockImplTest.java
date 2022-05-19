package chainBlock;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private List<Transaction> transactionList;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transactionList = new ArrayList<>();
        prepareTransactions();
    }

    private void prepareTransactions() {
        Transaction firstTransaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Pesho", 10.90);
        Transaction secondTransaction = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Desi", "Pesho", 10.80);
        Transaction thirdTransaction = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Desi", "Pesho", 10.70);
        Transaction forthTransaction = new TransactionImpl(4, TransactionStatus.FAILED, "Desi", "Pesho", 10.60);

        this.transactionList.add(firstTransaction);
        this.transactionList.add(secondTransaction);
        this.transactionList.add(thirdTransaction);
        this.transactionList.add(forthTransaction);
    }

    private void fillChainBlock() {
        this.transactionList.forEach(t -> chainblock.add(t));
    }

    @Test
    public void testContains() {
        Transaction transaction = this.transactionList.get(0);
        assertFalse(this.chainblock.contains(transaction));
        this.chainblock.add(transaction);
        assertTrue(this.chainblock.contains(transaction));
    }

    @Test
    public void testAddCorrectTransaction() {
        this.chainblock.add(transactionList.get(0));
        assertEquals(1, this.chainblock.getCount());
    }

    @Test
    public void testAddExistingTransaction() {
        this.chainblock.add(transactionList.get(0));
        assertEquals(1, this.chainblock.getCount());
        this.chainblock.add(transactionList.get(0));
        assertEquals(1, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeStatusWithZeroTransactions() {
        //0 transactions
        this.chainblock.changeTransactionStatus(this.transactionList.get(0).getId(),
                TransactionStatus.ABORTED);
    }

    @Test
    public void testChangeStatusTransaction() {
        Transaction transaction = transactionList.get(0);
        //0 transactions
        this.chainblock.add(transaction);
        //1 transaction
        assertEquals(1, this.chainblock.getCount());
        this.chainblock.changeTransactionStatus(transaction.getId(), TransactionStatus.FAILED);
        assertEquals(TransactionStatus.FAILED, transaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWithNoExistingId() {
        fillChainBlock();
        assertEquals(4, chainblock.getCount());
        this.chainblock.removeTransactionById(this.chainblock.getCount() + 1);
    }

    @Test
    public void testSuccessfulRemoveById() {
        fillChainBlock();
        assertEquals(4, chainblock.getCount());
        int id = this.transactionList.get(2).getId();
        this.chainblock.removeTransactionById(id);
        assertEquals(3, this.chainblock.getCount());
        assertFalse(this.chainblock.contains(id));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdWithNonExistingId() {
        fillChainBlock();
        this.chainblock.getById(this.chainblock.getCount() + 1);
    }

    @Test
    public void testCorrectGetById() {
        fillChainBlock();
        Transaction expected = this.transactionList.get(0);
        Transaction actual = this.chainblock.getById(expected.getId());
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByInvalidStatus() {
        fillChainBlock();
        this.chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetByTransactionStatus() {
        fillChainBlock();
        List<Transaction> successfulTransactions = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        Iterable<Transaction> result = this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertNotNull(result);

        List<Transaction> resultTransactions = new ArrayList<>();
        result.forEach(resultTransactions::add);

        assertEquals(successfulTransactions.size(), resultTransactions.size());

        resultTransactions.forEach(tr -> assertEquals(TransactionStatus.SUCCESSFUL, tr.getStatus()));

        assertEquals(successfulTransactions, resultTransactions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithNonExistingTransactionStatus() {
        fillChainBlock();
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllSendersWithExistingTransactionStatus() {
        fillChainBlock();
        List<String> expectedSenders = this.transactionList.stream()
                .filter(tr -> tr.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Iterable<String> result = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<String> resultSenders = new ArrayList<>();
        result.forEach(resultSenders::add);

        assertEquals(expectedSenders.size(), resultSenders.size());
        resultSenders.forEach(sender -> assertEquals("Desi", sender));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithNonExistingTransactionStatus() {
        fillChainBlock();
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllReceiversWithExistingTransactionStatus() {
        fillChainBlock();
        List<String> expectedReceivers = this.transactionList.stream()
                .filter(tr -> tr.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        Iterable<String> result = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<String> resultReceivers = new ArrayList<>();
        result.forEach(resultReceivers::add);

        assertEquals(expectedReceivers.size(), resultReceivers.size());
        resultReceivers.forEach(receiver -> assertEquals("Pesho", receiver));
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> result = this.chainblock.getAllOrderedByAmountDescendingThenById();
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected, actual);
    }
}