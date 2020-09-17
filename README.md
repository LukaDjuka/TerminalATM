# TerminalATM
## An ATM built to work in the Terminal. 
## Simulates the interactions a user would have with an ATM in real life.

This project was part of the curriculumn for the University of Toronto's Software Design - CSC207 course.

I worked on this project alongside 3 other group members - all decisions for functionality of the project were discussed as a group and each member
had a proper understanding of how the program functions.

Please contact me if you would like to know further information about the other group members' contributions to the project/contact info.

## Information about the Project
This program simulates an ATM running inside your terminal.

The program is run via the main method in the ATM class located in the ATM_Elements folder.

Upon startup you will be asked to log-in using one of the few pre-existing Persons that have been hardcoded
into the program. The instructions (Step 4) below contain information about these Persons.

The ATM is able to interact with three types of Persons: Users, Bank Managers, Assistant Bank Managers.
Each type of Person has their own actions they are able to perform using the ATM (more is explained in Step 4 of the instructions below).

## Notable features of the ATM (outside of the average features you've come to expect)
### Stocks
- Outside of the normal 'withdrawing and depositing' funcitonality you've come to expect with your average ATM, this program also allows the user to browse through
real world stocks using the webscraping functionality of the Jsoup library and the finance.yahoo website.<br/> Users are able to buy and sell stocks which are held in their
investment accounts on the ATM.<br/> The Buying and Selling of stocks results in changes to the user's Investment account balance.
### Two-factor authentification
- This feature is reliant on having an up-to-date Twilio account and a developer of the program present.<br/>
If a user of the TerminalATM mistakes their password one too many times on the login screen of the ATM, the user's account will be blocked until a Bank Manager logs in 
to unblock them.<br/> Furthermore, a developer of the program (who has their phone number linked to a Twilio account) will receieve an SMS text message in real life 
that alerts them that a user account had some suspicious activity. This SMS functionality can be extended to leave voicemails with text-to-speech information for the 
developer.
### Movement of money between users
- If a user of the ATM knows the userId of another user then they are able to send money to each other. They are also able to request the creation of a joint account
which they are able to share.<br/> A Bank Worker (Bank Manager or Assistant Bank Manager) must log in to process this request of a joint account.


## Instructions
### First Step:
You will need two external Libraries to run this. They are: Twilio and Jsoup.
- To download Twilio go to: https://repo1.maven.org/maven2/com/twilio/sdk/twilio/7.36.2/
        And press the twilio-7.36.2-jar-with-dependencies.jar file to download.
- To download Jsoup go to: https://jsoup.org/download
        And press the jsoup-1.11.3.jar  file to download.

It is also likely that later version of both the Twilio and Jsoup jar/class files will work.
The ones specified above were the latest version at the time of writing this program.

Save these files somewhere on your computer.
Twilio is used for texting and phone call functionality.
Jsoup is used for webscraping functionality.

### Second Step:
Ensure that the Twilio and Jsoup jar files are part of the referenced libraries when compiling and running the program.<br/>
Include both in the class path when compiling and running the program.

### Third Step:
The Project is run via the main method in the ATM class - located in the ATM_Elements Folder.<br/>
_Without a group member present, you cannot use the functionality of creating a request for a new user from the initial log-in screen._<br/>
_Please see ALERT 2 in the Notice section below for an explanation as to why._

### Fourth Step:
There are a few pre-existing Persons (1 Bank Manager, 1 Bank Assistant Manager and 2 Users):

    BankManager:
        username: bm
        password: 123

    AssistantBankManager:
        username: abm
        password: 123

    user1:
        username: user1
        password: abc

    user2:
        username: user2
        password: 123

Each type of Person has different functionality:
- User: Able to view accounts (Credit Card, Line of Credit, Chequing, Saving, Investment), make Deposits and Withdrawals, request the creation of new Accounts - regular and joint, manage investments.
- Bank Manager: Create new users, restock the ATM, undo recent transactions, process account creation requests, un-block users.
- Assistant Bank Manager: Create new users, process new account requests, act as a regular user.

### Fifth Step:
You can now use these Persons to do any tasks you like.
They each have their own home screen with processes you can select from.

Each user starts with one of each account available (Credit Card, Line of Credit, Chequing, Saving, Investment).
    Some requests require a BankWorker to process them before they go through/pass:
        - creation of a new user upon log in
        - creation of a request for a new account or joint account
        These things must be processed by a BankWorker before they begin to exist.

### NOTICE:
_ALERT ALERT ALERT - 1:_
    _IF THE PROGRAM FAILS TO RUN DUE TO THE INABILITY TO LOCATE THE NECESSARY ALERT TEXT FILE...
    THIS MIGHT BE DUE TO A CHANGE IN THE PATH UPON DOWNLOADING TO A NEW COMPUTER. PLEASE FIX THE PATH IN THE CODE MANUALLY
        - THE ALERT FILE PATH IS USED IN THE ATM CLASS' WRITEFILE METHOD AND THE BANKMANAGER'S FILLATM METHOD_

_ALERT ALERT ALERT - 2:
    FUNCTIONALITY OF TWILIO TEXT MESSAGING AND PHONE CALLING IS DEPENDANT OF HAVING A PRE-EXISTING VERIFIED PHONE NUMBER.
    AS OF RIGHT NOW, ONLY THE DEVELOPERS OF THE PROGRAM HAVE THEIR PHONE NUMBERS VERIFIED. FOR THIS REASON IT WILL FAIL TO WORK FOR NEW USERS.
        - THE PROGRAM TEXTS YOU IF YOU TRY TO MAKE A NEW USER FROM THE LOGIN SCREEN. IT ASKS FOR A 2-FACTOR AUTHENTICATION.
            YOU WILL NOT BE ABLE TO GET THIS INFORMATION UNLESS A GROUP MEMBER IS THERE. SO TO CREATE A NEW USER, PLEASE LOG IN AS BANK MANAGER
            AND DO IT FROM THEIR MAIN MENU.
        - THE PROGRAM CALLS YOU IF YOU TRY TO ENTER AN INCORRECT PASSWORD TO AN ACCOUNT 3 TIMES. IF YOU DO THIS IT WILL LOCK YOU OUT OF THE
        ACCOUNT UNTIL YOU LOG IN AS THE BANK MANAGER TO UN-LOCK THE ACCOUNT. YOU WILL NOT RECEIVE A PHONE CALL... A GROUP MEMBER WILL._

_ALERT ALERT ALERT - 3:
    FUNCTIONALITY OF THE WEBSCRAPER DEPENDS ON THE JSOUP LIBRARY. FURTHERMORE, WEBSCRAPER USES THE WEBPAGE OF FINANCE.YAHOO TO GET STOCK
    INFORMATION. IF THE WEBPAGE'S HTML CODE CHANGES UPON AN UPDATE TO THE WEBSITE (working as of March 31st, 2019) THEN THERE MIGHT BE AN ERROR
    AS THE WEBSCRAPER ATTEMPTS TO SEARCH THROUGH THE HTML CODE TO GET THE NECESSARY STOCK INFO._

