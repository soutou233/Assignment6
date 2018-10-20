public class PatronList {
    private BankPatron patron1;
    private BankPatron patron2;
    private BankPatron patron3;
    private BankPatron patron4;
    private BankPatron patron5;

    public PatronList(){
        patron1 = null;
        patron2 = null;
        patron3 = null;
        patron4 = null;
        patron5 = null;
    }
    public boolean addNewPatron(BankPatron patron){
        if (patron1 != null || patron2 != null || patron3 != null || patron4 != null || patron5 != null){
            if (patron1 != null){
                patron = patron1;
            }
            else if (patron2 != null){
                patron = patron2;
            }
            else if (patron3 != null){
                patron = patron3;
            }
            else if (patron4 != null){
                patron = patron4;
            }
            else if (patron5 != null){
                patron = patron5;
            }
        }
        else {
            return false;
        }
        return false;
    }

    public boolean addNewPatron(String fName, String sName, double s, double c){
        return addNewPatron(new BankPatron(fName, sName, s, c));
    }

    public BankPatron getPatron(int i){
        if (i == 0){
            return patron1;
        }
        else if (i == 1){
            return patron2;
        }
        else if (i == 2){
            return patron3;
        }
        else if (i == 3){
            return patron4;
        }
        else if (i == 4){
            return patron5;
        }
        else {
            return null;
        }
    }

    public BankPatron getPatronFullName(String fullName){
        if (patron1.getFullName().equalsIgnoreCase(fullName)){
            return patron1;
        }
        else if (patron2.getFullName().equalsIgnoreCase(fullName)){
            return patron2;
        }
        else if (patron3.getFullName().equalsIgnoreCase(fullName)){
            return patron3;
        }
        else if (patron4.getFullName().equalsIgnoreCase(fullName)){
        }
        else if (patron5.getFullName().equalsIgnoreCase(fullName)){
            return patron5;
        }
            return null;
    }

    public boolean removePatron(String patron) {
        if (patron1.getFullName().equalsIgnoreCase(patron)) {
            patron1 = null;
            return true;
        } else if (patron2.getFullName().equalsIgnoreCase(patron)) {
            patron2 = null;
            return true;
        } else if (patron3.getFullName().equalsIgnoreCase(patron)) {
            patron3 = null;
            return true;
        } else if (patron4.getFullName().equalsIgnoreCase(patron)) {
            patron4 = null;
            return true;
        } else if (patron5.getFullName().equalsIgnoreCase(patron)) {
            patron5 = null;
            return true;
        }
        else {
            return false;
        }
    }

    public String patronInfo(){
        String patronInfo = "";
        String space = " ";
        String balance = " Balance: ";
        String rate = " Interest Rate: ";
        for (int i =0; i <=5; i++){
            BankPatron patron = getPatron(i);
            if (patron != null){
                patronInfo += space + patron.getFullName();
            }
            BankAccount account = patron.getAccount(1);
            if (account != null){
                patronInfo += (space + account.getType() + space + account.getAccountNum() + balance + account.checkBalance() + rate + account.getRate() + ".\n");
            }
            account = patron.getAccount(2);
            if (account != null){
                patronInfo += (space + account.getType() + space + account.getAccountNum() + balance + account.checkBalance() + rate + account.getRate() + ".\n");
            }
            if (patronInfo.equalsIgnoreCase("")){
                return "None";
            }
        }
        return patronInfo;
    }

}
