package builder;

public class TourApp {
    public static void main(String[] args) {
        Tour tour = new Tour.Builder(false,true,false)
//                .isFlightToResortIncluded(true)
//                .isFlightFromResortIncluded(true)
//                .isBookingIncluded(true)
                .build();

    }
}
