package observer;

import java.util.ArrayList;
import java.util.List;

 public class TypographyApp{
     public static void main(String[] args) {
         Typography typography = new Typography();
         typography.addSuscriber(new VillageSubscriber("Petro"));
         typography.addSuscriber(new VillageSubscriber("Ivan"));
         typography.addSuscriber(new VillageSubscriber("Dmytro"));
         typography.setNewsPaper("Village Reader");
         typography.setCirculation(typography.getSubscribers().size());
         typography.sendPapersToSubscribers();
     }
 }

 class Typography implements Subscribeable {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String newsPaper;
    private int circulation;

     public String getNewsPaper() {
         return newsPaper;
     }

     public void setNewsPaper(String newsPaper) {
         this.newsPaper = newsPaper;
     }

     public void setCirculation(int circulation) {
         this.circulation = circulation;
     }

     public int getCirculation() {
         return circulation;
     }

     public List<Subscriber> getSubscribers() {
         return subscribers;
     }
     public void setSubscribers(List<Subscriber> subscribers) {
         this.subscribers = subscribers;
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
    public void sendPapersToSubscribers() {
        System.out.println("Was printed " + this.getCirculation() + " pieces of newspaper " + this.getNewsPaper());
        for (Subscriber subscriber:subscribers) {
            subscriber.getNewspaper(this.getNewsPaper());
        }
    }
}

interface Subscriber{
    void getNewspaper(String newsPaper);
}

interface Subscribeable{
    void addSuscriber(Subscriber s);
    void removeSubscriber(Subscriber s);
    void sendPapersToSubscribers();
}

class VillageSubscriber implements Subscriber {
    private String name;
    private List<String> newspapers;

    VillageSubscriber (String name) {
            this.name = name;
        }

    @Override
    public String toString() {
        return "VillageSubscriber{" +
                "name='" + name + '\'' +
                ", newspapers=" + newspapers +
                '}';
    }

    @Override
    public void getNewspaper(String newsPaper) {
        System.out.println(this.name + " got an instance of " + newsPaper + " newsPaper");
    }


}
