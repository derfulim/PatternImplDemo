package builder.tour;

public class Tour {

    private boolean isTransferToAirportIncluded;
    private boolean isTransferFromAirportIncluded;
    private boolean isFlightToResortIncluded;
    private boolean isFlightFromResortIncluded;
    private boolean isBookingIncluded;
    private boolean isInsuranceIncluded;

    public static class Builder {
       //required parameters
        private boolean isTransferToAirportIncluded = false;
        private boolean isTransferFromAirportIncluded = false;
        private boolean isInsuranceIncluded = false;
        //not required parameters
        private boolean isFlightToResortIncluded = true;
        private boolean isFlightFromResortIncluded = true;
        private boolean isBookingIncluded = true;

        public Builder(boolean isTransferToAirportIncluded, boolean isTransferFromAirportIncluded, boolean isInsuranceIncluded) {
            this.isTransferToAirportIncluded = isTransferToAirportIncluded;
            this.isTransferFromAirportIncluded = isTransferFromAirportIncluded;
            this.isInsuranceIncluded = isInsuranceIncluded;
        }

        public Builder isFlightToResortIncluded(boolean var) {
            isFlightToResortIncluded = var;
            return this;
        }
        public Builder isFlightFromResortIncluded(boolean var) {
            isFlightFromResortIncluded = var;
            return this;
        }

        public Builder isBookingIncluded(boolean var){
            isBookingIncluded = var;
            return this;
        }

        public Tour build() {
            return new Tour(this);
        }
    }
        private Tour(Builder builder){
        isTransferToAirportIncluded = builder.isTransferToAirportIncluded;
        isTransferFromAirportIncluded = builder.isTransferFromAirportIncluded;
        isInsuranceIncluded = builder.isInsuranceIncluded;
        isFlightToResortIncluded = builder.isFlightToResortIncluded;
        isFlightFromResortIncluded = builder.isFlightFromResortIncluded;
        isBookingIncluded = builder.isBookingIncluded;
        }
}
