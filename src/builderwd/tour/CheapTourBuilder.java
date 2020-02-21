package builderwd.tour;

public class CheapTourBuilder extends AbstractBuilder {

    @Override
    void buildTransfers() {
        tour.setTransferToAirportIncluded(false);
        tour.setTransferFromAirportIncluded(false);
    }

    @Override
    void buildFlights() {
        tour.setFlightToResortIncluded(true);
        tour.setFlightFromResortIncluded(true);
    }

    @Override
    void buildBooking() {
        tour.setBookingIncluded(true);
    }

    @Override
    void buildInsurance() {
        tour.setInsuranceIncluded(false);
    }
}
