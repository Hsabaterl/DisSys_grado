package bankaccount;



public class AcmeBankAccounts { 

    int balance = 0;  
    String holder;  
    int accountNumber;  
    static int idAccounts = 1; //First number account  to use 
    static int BankBalance = 0; // Total bank balance 
    AcmeBankAccounts (String holder, int initialBalance) { 
    // Create a new bank account for a client holder with an initial balance >= 0 
    // it will assign to the bank account an idAccount 
    // To be coded by the student 
        this.holder = holder;
        this.balance = initialBalance;
        this.accountNumber = idAccounts++;
        BankBalance += this.balance;
    } 
    
    static void printBankData() { 
    // Print the total Balance of the bank and the current accounts. 
    // To be coded by the student 
        System.out.println("Total Balance of the Bank: " + BankBalance);
    } 
    
    void  withdrawal (int amount) { 
    // For the current account, withdrawal the indicated amount 
    // Decrement also the Bank balance 
    // To be coded by the student
        this.balance -= amount;
        BankBalance -= amount;
        System.out.println("Retiro realizado con exito.");
    } 
    
    void deposit(int amount) { 
    // To be coded by the student 
        balance += amount;
        System.out.println("Deposito realizado con exito.");
    } 
    
    void transfer (AcmeBankAccounts destinationAccount, int amount) { 
    //Transfert the amount to the destination Account 
    // To be coded by the student 
        destinationAccount.deposit(amount);
        balance -= amount;
        BankBalance -= amount;
    } 
    
    void printAccountData() { 
    // print the account number, holder and  account balance 
    // To be coded by the student 
        System.out.println("Holder: " + holder);
        System.out.println("Balance: " + balance);
    } 
    
    public static void main(String[] args) { 
        AcmeBankAccounts cJuan = new AcmeBankAccounts ("Juan", 2000); 
        AcmeBankAccounts cPepe = new AcmeBankAccounts ("Pepe", 3000); 
        cJuan.printAccountData(); 
        cPepe.printAccountData(); 
        cJuan.transfer(cPepe, 1000); 
        cJuan.printAccountData(); 
        cPepe.printAccountData(); 
        AcmeBankAccounts.printBankData();  
    } 
} 