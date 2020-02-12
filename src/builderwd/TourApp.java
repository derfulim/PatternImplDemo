package builderwd;

public class TourApp {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new LuxuryTourBuilder());
        Tour tour = director.buildTour();
        System.out.println(tour.toString());
    }
}
