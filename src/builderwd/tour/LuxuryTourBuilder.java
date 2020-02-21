package builderwd.tour;

public class LuxuryTourBuilder extends AbstractBuilder {
    @Override
    void buildTransfers() {
        tour.setTransferToAirportIncluded(true);
        tour.setTransferFromAirportIncluded(true);
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
        tour.setInsuranceIncluded(true);
    }
}
