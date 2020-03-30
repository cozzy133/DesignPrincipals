package ie.gmit.single;
/*
Authors: Padraig O Cosgora, Paul Lennon
Date: 30/03/2020
Version: 2.0
Description: This class enables the user to choose the validation method.

 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Stores data in memory
public class Validation {

    public boolean success(User user){
        if(!isValidUser(user)) {
            return false;
        }
        else
            return true;
    }

    //Validates the user object
    private boolean isValidUser(User user) {
        if(!isPresent(user.getName())) {
            return false;
        }
        user.setName(user.getName().trim());

        if(!isValidAlphaNumeric(user.getName())) {
            return false;
        }
        if(user.getEmail() == null || user.getEmail().trim().length() == 0) {
            return false;
        }
        user.setEmail(user.getEmail().trim());
        if(!isValidEmail(user.getEmail())) {
            return false;
        }
        return true;
    }

    //Simply checks if value is null or empty..
    private boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }
    //check string for special characters
    private boolean isValidAlphaNumeric(String value) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(value);
        return !matcher.find();
    }
    //check string for valid email address - this is not for prod.
    //Just for demo. This fails for lots of valid emails.
    private boolean isValidEmail(String value) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}