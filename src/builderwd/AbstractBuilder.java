package builderwd;

public abstract class AbstractBuilder {

    Tour tour;

    public void createTour() {tour = new Tour();}

    abstract void buildTransfers();
    abstract void buildFlights();
    abstract void buildBooking();
    abstract void buildInsurance();

    public Tour getTour() {
        return tour;
    }

}
