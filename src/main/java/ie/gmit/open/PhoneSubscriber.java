package ie.gmit.open;
/*
Authors: Padraig O Cosgora, Paul Lennon
Date: 30/03/2020
Version: 2.0
Description: This class inherits the Subscriber class and calculates a bill.

 */

import java.util.List;

public class PhoneSubscriber extends Subscriber {

    public PhoneSubscriber() {
        super();
    }

    @Override
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(getSubscriberId());
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return totalDuration*getBaseRate()/100;
    }

}