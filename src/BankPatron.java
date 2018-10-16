public class BankPatron {

    private String firstName;
    private String lastName;
    private double salary;
    private double cashOnHand;
    private BankAccount firstAccount;
    private BankAccount secondAccount;

    public BankPatron(){
        firstName = "";
        lastName = "";
        salary = 0;
        cashOnHand = 0;
        firstAccount = null;
        secondAccount = null;

    }

    public BankPatron(String fn, String ln, double s, double coh){
        firstName = fn;
        lastName = ln;
        salary = s;
        cashOnHand = coh;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public double getSalary(){
        return salary;
    }

    public double getCashOnHand(){
        return cashOnHand;
    }

    public void payCheck(){
        double weekSalary = salary /52;
        cashOnHand = cashOnHand + (2 * weekSalary);
    }

    public BankAccount getAccount(int account){
        if (account == 1){
            return firstAccount;
        }
        else if (account == 2){
            return secondAccount;
        }
        else {
            return null;
        }
    }

    public boolean deposit(double amount, int accountN){
        BankAccount account = getAccount(accountN);
        if (account != null && cashOnHand >= amount){
            account.deposit(amount);
            cashOnHand -= amount;
            return true;
        }
        else {
            return false;
        }
    }
}
