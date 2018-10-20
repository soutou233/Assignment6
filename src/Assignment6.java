import java.util.Scanner;

public class Assignment6 {

    static Scanner scan = new Scanner(System.in);
    static PatronList patronList = new PatronList();

    public static String menu(){

        System.out.println("a. List Patrons");
        System.out.println("b. Add New Patron");
        System.out.println("c. Remove Patron");
        System.out.println("d. Patron Specific Actions");
        System.out.println("e. Quit");
        String input = scan.nextLine();
        return input;
    }

    public static String patronMenu(){
        System.out.println("a. Add New Account");
        System.out.println("b. Close Account");
        System.out.println("c. Get Paid");
        System.out.println("d. Apply Interest to Accounts");
        System.out.println("e. Make Deposit");
        System.out.println("f. Make Withdraw");
        System.out.println("g. Return to Main Menu");
        String input = scan.nextLine();
        return input;
    }

    public static void accountMenu(){
        System.out.println("a. Checking");
        System.out.println("b. Savings");
        System.out.println("e. CD");
        System.out.println("f. Money Market");
        System.out.println("g. IRA");
    }

    public static void patronMenuAction(BankPatron patron){
        String input = patronMenu();
        while (!input.equalsIgnoreCase("g")){
            switch (input){
                case "a":
                    System.out.println("Which account type did you want?");
                    accountMenu();
                    String inputAccountType = scan.nextLine();
                    AccountType accountType = null;
                    switch (inputAccountType){
                        case "a":
                            accountType = AccountType.Checking;
                            break;
                        case "b":
                            accountType = AccountType.Savings;
                            break;
                        case "c":
                            accountType = AccountType.CD;
                            break;
                        case "d":
                            accountType = AccountType.MoneyMarket;
                            break;
                        case "e":
                            accountType = AccountType.IRA;
                            break;
                        default:
                            accountMenu();
                            break;
                    }
                    System.out.println("Please input the interest rate.");
                    double inputInterestRate = scan.nextDouble();
                    scan.nextLine();
                    patron.addAccount(inputInterestRate, accountType);
                    if (patron.addAccount(inputInterestRate, accountType)){
                        System.out.println("Account successfully added.");
                        break;
                    }
                    else {
                        System.out.println("failed!");
                        break;
                    }

                case "b":
                    System.out.println("Which account (1 or 2) you want to close.");
                    int removeAccountNumber = scan.nextInt();
                    scan.nextLine();
                    if (patron.removeAccount(removeAccountNumber)){
                        System.out.println("Account closed successfully!");
                        break;
                    }
                    else {
                        System.out.println("Failed.");
                        break;
                    }
                case "c":
                    patron.payCheck();
                    break;
                case "d":
                    BankAccount account = patron.getAccount(1);
                    if (account != null){
                        account.applyInterest();
                        account = patron.getAccount(2);
                    }
                    if (account != null){
                        account.applyInterest();
                    }
                    break;
                case "e":
                    System.out.println("Which account(1 or 2) did you want to make a deposit in?");
                    int depositAccount = scan.nextInt();
                    scan.nextLine();
                    System.out.println("How much you want to deposit?");
                    double depositAmount = scan.nextDouble();
                    scan.nextLine();
                    if (patron.getAccount(depositAccount) == null){
                        System.out.println("Error.");
                        break;
                    }
                    if (patron.deposit(depositAmount, depositAccount)){
                        System.out.println("Deposit made!");
                        break;
                    }
                    else {
                        System.out.println("Patron does not have enough money on hand.");
                        break;
                    }
                case "f":
                    System.out.println("Which account(1 or 2) did you want to make a withdraw in?");
                    int withdrawAccount = scan.nextInt();
                    scan.nextLine();
                    System.out.println("How much you want to with draw?");
                    double withdrawAmount = scan.nextDouble();
                    scan.nextLine();
                    if (patron.getAccount(withdrawAccount) == null){
                        System.out.println("Error.");
                        break;
                    }
                    if (patron.withdraw(withdrawAmount, withdrawAccount)){
                        System.out.println("Withdraw made.");
                        break;
                    }
                    else {
                        System.out.println("Patron does not have enough money to withdraw.");
                        break;
                    }
            }
            input = patronMenu();

        }
        menu();
    }

    public static void main(String args[]){

        System.out.println("Welcome to the CSE 110 Bank!");
        String input = menu();
        while (!input.equalsIgnoreCase("e")){
            switch (input){
                case "a":
                    patronList.patronInfo();
                    break;
                case "b":
                    System.out.println("What is the first name of the new patron?");
                    String fName = scan.nextLine();
                    System.out.println("Their last name?");
                    String lName = scan.nextLine();
                    System.out.println("Their yearly salary?");
                    double salary = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("How much cash do they have on hand?");
                    double cashOnHand = scan.nextDouble();
                    scan.nextLine();
                    BankPatron p = new BankPatron(fName, lName, salary, cashOnHand);
                    if(!patronList.addNewPatron(p)){
                        System.out.println("The line at the bank is full already.");
                        break;
                    }
                    else {
                        System.out.println("Welcome to the bank, " + fName);
                        break;
                    }
                case "c":
                    System.out.println("Type the full name of the patron you want.");
                    String fullName = scan.nextLine();
                    if(patronList.getPatronFullName(fullName) == null){
                        System.out.println("There is no patron by that name");
                        break;
                    }
                    else {
                        patronList.removePatron(fullName);
                        System.out.println(fullName + "left the bank.");
                        break;
                    }
                case "d":
                    System.out.println("Type the full name of the patron you want.");
                    String fullName2 = scan.nextLine();
                    if (patronList.getPatronFullName(fullName2) == null){
                        System.out.println("That patron doesn't exist.");
                    }
                    else {
                        BankPatron patron = patronList.getPatronFullName(fullName2);
                        patronMenuAction(patron);
                    }
                    System.out.println("What do you want to do with " + fullName2);
            }
            input = menu();
        }
    }
}
