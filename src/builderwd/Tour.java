package builderwd;

public class Tour {

    private boolean isTransferToAirportIncluded;
    private boolean isTransferFromAirportIncluded;
    private boolean isFlightToResortIncluded;
    private boolean isFlightFromResortIncluded;
    private boolean isBookingIncluded;
    private boolean isInsuranceIncluded;

    public void setTransferToAirportIncluded(boolean transferToAirportIncluded) {
        isTransferToAirportIncluded = transferToAirportIncluded;
    }

    public void setTransferFromAirportIncluded(boolean transferFromAirportIncluded) {
        isTransferFromAirportIncluded = transferFromAirportIncluded;
    }

    public void setFlightToResortIncluded(boolean flightToResortIncluded) {
        isFlightToResortIncluded = flightToResortIncluded;
    }

    public void setFlightFromResortIncluded(boolean flightFromResortIncluded) {
        isFlightFromResortIncluded = flightFromResortIncluded;
    }

    public void setBookingIncluded(boolean bookingIncluded) {
        isBookingIncluded = bookingIncluded;
    }

    public void setInsuranceIncluded(boolean insuranceIncluded) {
        isInsuranceIncluded = insuranceIncluded;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "isTransferToAirportIncluded=" + isTransferToAirportIncluded +
                ", isTransferFromAirportIncluded=" + isTransferFromAirportIncluded +
                ", isFlightToResortIncluded=" + isFlightToResortIncluded +
                ", isFlightFromResortIncluded=" + isFlightFromResortIncluded +
                ", isBookingIncluded=" + isBookingIncluded +
                ", isInsuranceIncluded=" + isInsuranceIncluded +
                '}';
    }
}
