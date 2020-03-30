package ie.gmit.open;
/*
Authors: Padraig O Cosgora, Paul Lennon
Date: 30/03/2020
Version: 2.0
Description: This class inherits the Subscriber class and calculates a bill.

 */

import java.util.List;

public class ISPSubscriber extends Subscriber {

    private long freeUsage;

    public ISPSubscriber() {
        super();
    }

    @Override
    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(getSubscriberId());
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return chargeableData*getBaseRate()/100;
    }

    /**
     * @return the freeUsage
     */
    public long getFreeUsage() {
        return freeUsage;
    }

    /**
     * @param freeUsage the freeUsage to set
     */
    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }


}