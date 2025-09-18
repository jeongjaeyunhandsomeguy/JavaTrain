package PHY.O910.bank;

public class Account {
    private String accountNumber;
    private String name;
    private int pw;
    private long balance;

    public Account(String accountNumber, String name, long balance, int pw) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.pw=pw;
    }

    public int getPw() {
        return pw;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void withdraw(long amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("残額不足");
        }
    }

    public void print() {
        System.out.println("名義人   : " + name);
        System.out.println("口座番号 : " + accountNumber);
        System.out.println("残額    : " + balance + "円");
    }
}
