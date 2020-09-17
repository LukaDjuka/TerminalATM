package main.java.ATM;

import java.net.URI;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Call;

public class SMS {
    // Find your Account Sid and Token at twilio.com/user/account
    String ACCOUNT_SID;
    String AUTH_TOKEN;
    public SMS(){
       this.ACCOUNT_SID =  "INSERT ACCOUNT SID";
       this.AUTH_TOKEN = "INSERT AUTHENTIFICATION TOKEN";
    }

    public void send_text(String text){

        String user_number = "INSERT USER PHONE NUMBER";
        String twilio_number = "INSERT TWILIO NUMBER";
        Twilio.init(this.ACCOUNT_SID, this.AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(user_number), new PhoneNumber(twilio_number), text).create();
        System.out.println(message.getSid());
    }

    public void call(){
        String user_number = "+16474734751";
        String twilio_number = "+12264074008";
        Twilio.init(this.ACCOUNT_SID, this.AUTH_TOKEN);
        Call call = Call.creator(
                new com.twilio.type.PhoneNumber(user_number),
                new com.twilio.type.PhoneNumber(twilio_number),
                URI.create("INSERT PHONE CALL XML"))
                .create();

        System.out.println(call.getSid());
        }

    }

