package chainBlock;

import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactionByIds;

    public ChainblockImpl() {
        this.transactionByIds = new HashMap<>();
    }

    public int getCount() {
        return this.transactionByIds.size();
    }

    public void add(Transaction transaction) {
        int id = transaction.getId();
        if (!transactionByIds.containsKey(id)) {
            this.transactionByIds.put(id, transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        if (this.transactionByIds.containsKey(id)) {
            return true;
        }
        return false;
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.transactionByIds.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        Transaction transaction = this.transactionByIds.get(id);
        transaction.setStatus(newStatus);
        this.transactionByIds.put(id, transaction);
    }

    public void removeTransactionById(int id) {
        if (!transactionByIds.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        this.transactionByIds.remove(id);
    }

    public Transaction getById(int id) {
        if (!transactionByIds.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return this.transactionByIds.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : this.transactionByIds.values()) {
            if (transaction.getStatus() == status) {
                filteredTransactions.add(transaction);
            }
        }
        if (filteredTransactions.size() == 0) {
            throw new IllegalArgumentException();
        }
        filteredTransactions.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return filteredTransactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        getByTransactionStatus(status).forEach(filteredTransactions::add);

        filteredTransactions = filteredTransactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        List<String> senders = filteredTransactions.stream()
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        if (senders.size() == 0) {
            throw new IllegalArgumentException();
        }
        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        getByTransactionStatus(status).forEach(filteredTransactions::add);

        filteredTransactions = filteredTransactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        List<String> receivers = filteredTransactions.stream()
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        if (receivers.size() == 0) {
            throw new IllegalArgumentException();
        }
        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionByIds.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
