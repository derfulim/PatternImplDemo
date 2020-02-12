package builderwd;

public class Director {
    AbstractBuilder builder;
    Tour tour;

    public void setBuilder(AbstractBuilder builder) {
        this.builder = builder;
    }

    Tour buildTour() {
        builder.createTour();
        builder.buildTransfers();
        builder.buildFlights();
        builder.buildBooking();
        builder.buildInsurance();
        Tour tour = builder.getTour();
        return tour;
    }






}
