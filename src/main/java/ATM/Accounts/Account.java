/**
 * Created by joshuaefe on 2019-02-25.
 */

package main.java.ATM.Accounts;

import main.java.ATM.ATM_Elements.ATMWithdraw;
import main.java.ATM.Transaction.*;
import main.java.ATM.enums.UserStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static main.java.ATM.Person.Persons.User_Elements.User.userStatus;

public abstract class Account {

    // Recent Transaction Information
   public ArrayList<Transaction> listOfRecentTransactions = new ArrayList<Transaction>(10);

    //Todo may add a joint status so a user can see all joint accounts

    public String type;

    public double balance;

    LocalDate date = LocalDate.now();
    LocalTime clockTime = LocalTime.now();
    String time = clockTime.toString() +" " +"on "+" " + date.toString();
    public String timeCreated = clockTime.toString() +" " +"on "+" " + date.toString();

    // There is functionality for an account to be a Joint Account. This boolean tells you whether that's the case
    public boolean isJoint = false;

    // Adds a Transaction to the ArrayList - listOfRecentTransactions. Only maintains 10 in the list.
    public void addTransaction(Transaction t){
        if (listOfRecentTransactions.size() == 10){
            listOfRecentTransactions.remove(0);
            listOfRecentTransactions.add(t);
        }
        else{
            listOfRecentTransactions.add(t);
        }
    }

    // Removes a specified Transaction object from the list of recent transactions
    public void removeTransaction(Transaction t){
        listOfRecentTransactions.remove(t);
    }

    /**
     * Returns an Object[] where the Object in the first index is a long String of information about each recent
     * transaction. The Object in the second index is the size of the list of recent transactions
     * @return
     */
    public Object[] provideInformationForChoosingTransaction(){
        StringBuilder message = new StringBuilder("");
        int sizeOfList = listOfRecentTransactions.size() - 1;
        for (int i = 0; i < listOfRecentTransactions.size(); i++){
            String thingToAppend = i + "." + listOfRecentTransactions.get(i).toString() + "\n";
            message.append(thingToAppend);
        }
        Object[] informationForScreen = {message, sizeOfList};
        return informationForScreen;
    }

   public void setDate() {
       LocalDate date = LocalDate.now();
       LocalTime clockTime = LocalTime.now();
       this.timeCreated = clockTime.toString() +" " +"on "+" " + date.toString();
   }

   public void setDate(LocalDate date){
        this.date = date;
   }

    @Override // Needed to print primitive with strings
    public String toString() {
        // Needs to autocast out into a double so that we can print as a String.
        Double holder = balance;
        return holder.toString();
    }

    public double getBalance() {
        return balance;
    }

    // This method will be overridden in subclasses
    public boolean withdraw(String amount){return false;}

    // This method will be overridden in subclasses
    public boolean deposit(String amount) {return false;}

    // This checks withdrawing cash from ATM, if yes only true if ATM supports action and ATM will update bills
    public boolean cashWithdrawCheckAct(String amount){
        double cashamount = Double.parseDouble(amount);
        if (userStatus == UserStatus.WITHDRAW) {
            ATMWithdraw atmWithdraw = new ATMWithdraw();
            return atmWithdraw.WithdrawContents(cashamount);
        }
        return true;
    }

    // Check to make sure the string amount given is in fact a double (number). Operations done within the ATM
    // are all through the command line so inputs/arguments are strings
    public boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
