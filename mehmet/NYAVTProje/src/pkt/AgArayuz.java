package pkt;

import java.util.ArrayList;
import java.util.List;

public class AgArayuz implements ISubject{
    
	private List<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver o) {
        subscribers.add(o);
    }

    @Override
    public void detach(IObserver o) {
        subscribers.remove(o);
    }

    @Override
    public void notify(int sicaklik) {
        for(IObserver subscriber: subscribers) {
            subscriber.update(sicaklik);
        }
    }

}
