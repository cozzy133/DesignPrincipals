package ie.gmit.open;

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