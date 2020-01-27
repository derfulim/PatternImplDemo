package observer;

import java.util.ArrayList;
import java.util.List;

 public class TypographyApp{
     Typography typography = new Typography();

 }

 class Typography implements Subscribeable {

    private List<Subscriber> subscribers;

     public List<Subscriber> getSubscribers() {
         return subscribers;
     }

     public void setSubscribers(List<Subscriber> subscribers) {
         this.subscribers = subscribers;
     }

     private Circulation circulation;

    public Circulation getCirculation() {
        return circulation;
    }

    public void setCirculation(Circulation circulation) {
        this.circulation = circulation;
    }

    public Typography() {
        super();
    }

    @Override
    public void addSuscriber(Subscriber s) {
        subscribers.add(s);
    }

    @Override
    public void removeSubscriber(Subscriber s) {
        subscribers.remove(s);
    }

    @Override
    public void sendPapersToSubscribers(Newspaper newspaper) {

    }
}

class Circulation{
    private int amount;
    private Newspaper newspaper;

    public int getAmount() {
        return amount;
    }

    public Newspaper getNewspaper() {
        return newspaper;
    }

    Circulation(int amount, Newspaper newspaper) {
        this.amount = amount;
        this.newspaper = newspaper;
    }


}

interface Subscriber{
    void getNewspaper();
}

interface Subscribeable{
    void addSuscriber(Subscriber s);
    void removeSubscriber(Subscriber s);
    void sendPapersToSubscribers(Newspaper newspaper);
}

class VillageSubscriber implements Subscriber {
    private String name;

    @Override
    public String toString() {
        return "VillageSubscriber{" +
                "name='" + name + '\'' +
                ", newspapers=" + newspapers +
                '}';
    }

    VillageSubscriber (String name) {
        this.name = name;
    }

    List<Newspaper> newspapers = new ArrayList<>();

    @Override
    public void getNewspaper() {
    }


}

class Newspaper {}
