import java.util.ArrayList;
import java.util.List;

public class StrategyApp {
    public static void main(String[] args) {
       Fighter fighter = new Fighter("F-22", new String[]{"cannon", "missile"}, true, Location.AIR);
       if((fighter.location==Location.AIR)&&(fighter.getWeapon().length>0)&&(fighter.isAmmoStockEnabled)){fighter.doAction(new Shooting(fighter));}
       else if ((fighter.location == Location.AIR)&&((!fighter.isAmmoStockEnabled)||(fighter.getWeapon().length == 0))) {
           fighter.doAction(new Flying(fighter));
       }
       else if (fighter.location == Location.GROUND) {
           fighter.doAction(new Staying(fighter));
       }
    }
    }

class Fighter{
    private String title;
    private String [] weapon;
    boolean isAmmoStockEnabled;
    Location location;


    public Fighter(String title, String [] ammunition, boolean isAmmoStockEnabled, Location location) {
        this.title = title;
        this.weapon = ammunition;
        this.isAmmoStockEnabled = isAmmoStockEnabled;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String[] getWeapon() {
        return weapon;
    }

    public void doAction(Action action){
        action.doAction();
    }
}

enum Location{
    AIR,GROUND
}

interface Action{
    void doAction();

}

class Shooting implements Action{
    private Fighter fighter;
    public Shooting(Fighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public void doAction() {
        for(String weapon:fighter.getWeapon()){
            System.out.println(fighter.getTitle() + " is shooting from " + weapon);
                }
        }
}

class Flying implements Action{
    private Fighter fighter;
        public Flying(Fighter fighter) {
            this.fighter = fighter;
        }

    @Override
    public void doAction() {
        System.out.println(fighter.getTitle() + " is just flying");
    }
}

class Staying implements Action{
    private Fighter fighter;
            public Staying(Fighter fighter) {
                this.fighter = fighter;
            }

    @Override
    public void doAction() {
        System.out.println(fighter.getTitle() + " is staying on the ground");
    }
}




